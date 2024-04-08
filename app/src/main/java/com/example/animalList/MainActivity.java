package com.example.animalList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import com.example.animalList.adapter.ExamAdapter;
import com.example.animalList.model.Exam;

import java.util.List;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity
{
    ExamAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar= (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        List<Exam> list = new ArrayList<>();
        list = getData();

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        adapter = new ExamAdapter(list, getApplication());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    // Sample data for RecyclerView
    private List<Exam> getData()
    {
        List<Exam> list = new ArrayList<>();
        list.add(new Exam("First Exam",
                "May 23, 2015",
                "Best Of Luck"));
        list.add(new Exam("Second Exam",
                "June 09, 2015",
                "b of l"));
        list.add(new Exam("My Test Exam",
                "April 27, 2017",
                "This is testing exam .."));

        return list;
    }


}