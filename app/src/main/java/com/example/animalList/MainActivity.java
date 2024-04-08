package com.example.animalList;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.animalList.model.Animal;
import com.example.animalList.adapter.AnimalAdapter;
import java.util.List;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_DETAIL_ACTIVITY = 1;
    private List<Animal> mAnimalList= new ArrayList<>();
    private AnimalAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Get references to the buttons
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);

        // Set OnClickListener for button1
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the selectFragment() function with the clicked view
                selectFragment(v);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectFragment(v);
            }
        });
    }

    public void selectFragment(View view) {
        // creating object for Fragment
        Fragment fr;

        if(view == findViewById(R.id.button1)) {
            fr = new FirstFragment();
        }
        else {
            fr = new SecondFragment();
        }

        FragmentManager fm = getFragmentManager();

        // fragments while activity is running
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_section, fr);


        fragmentTransaction.commit();
    }


}