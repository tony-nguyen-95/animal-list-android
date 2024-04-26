package com.example.animalList;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;

import com.example.animalList.model.Animal;
import com.example.animalList.adapter.AnimalAdapter;
import java.util.List;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}