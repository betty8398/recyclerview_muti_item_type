package com.example.recyclerview3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.viewHolder> {

    private ArrayList<NoteData> myListString;
    private final Context myContext;


    public CardViewAdapter(Context context){
        myContext = context;
//        myListString = listString;
    };

    @NonNull
    @Override
    public com.example.recyclerview3.CardViewAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if(viewType==0){
            view= LayoutInflater.from(myContext).inflate(R.layout.recyclerview_title_item, parent, false);
        }else {
            view= LayoutInflater.from(myContext).inflate(R.layout.recyclerview_item, parent, false);
        }

        viewHolder holder = new viewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.recyclerview3.CardViewAdapter.viewHolder holder, int position) {
        if (myListString.get(position).getViewType()==0){
            holder.textView_title.setText("title");
        }else {
            holder.textView_dataID.setText(myListString.get(position).getTime());
             //holder.itemView.setVisibility(View.GONE);  //用消失代替縮合效果
            //holder.imageView_dataID.setImageResource(R.drawable.cat_1);
        }
    }

    public void setData(ArrayList<NoteData> myListString){
        this.myListString =myListString;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return myListString.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return myListString.size();
    };


    public class viewHolder extends RecyclerView.ViewHolder{
        private final ImageView imageView_dataID;
        private final TextView textView_dataID;
        private TextView textView_title;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView_dataID = (ImageView) itemView.findViewById(R.id.rv_img);
            textView_dataID = (TextView) itemView.findViewById(R.id.rv_time);
            textView_title = itemView.findViewById(R.id.title);
        }
    }
}