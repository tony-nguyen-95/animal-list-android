package com.example.animalList;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

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

        DrawerLayout drawerLayout = findViewById(R.id.my_drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // to make the Navigation drawer icon always appear on the action bar
        if (getSupportActionBar() != null) {
            // Enable the "up" button (the hamburger icon)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
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