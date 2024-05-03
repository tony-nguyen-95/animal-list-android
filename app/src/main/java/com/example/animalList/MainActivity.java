package com.example.animalList;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.animalList.fragment.MenuFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }

    private void initViews() {
        MenuFragment menuFragment = new MenuFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.ln_main, menuFragment)
                .addToBackStack(null)
                .commit();
    }





}
