package com.example.animalList;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Inflate the loading layout
        View loadingView = getLayoutInflater().inflate(R.layout.loading_layout, null);

        // Add the loading layout to the main layout of the activity
        ViewGroup rootView = findViewById(android.R.id.content);
        rootView.addView(loadingView);
    }

}