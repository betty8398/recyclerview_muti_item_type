package com.example.recyclerview3;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<NoteData> myListString;
    private CardViewAdapter cardViewAdapter;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        cardViewAdapter = new CardViewAdapter(this);
        StaggeredGridLayoutManager myLayoutManager_Staggered = new StaggeredGridLayoutManager(1, 1);
        recyclerView.setLayoutManager(myLayoutManager_Staggered);
        recyclerView.setAdapter(cardViewAdapter);
        setData();
        cardViewAdapter.setData(myListString);
    }
    private void setData(){
        myListString = new ArrayList<>();
        for (int i =0;i<10;i++){
            NoteData noteData = new NoteData();
            if(i==0){
                //塞 video title
//                noteData.setTitle("");
                noteData.setViewType(0);
            }else {
                //塞 note
                noteData.setViewType(1);
                noteData.setTime("00:00:11");
            }
            myListString.add(noteData);
        }
    }
}