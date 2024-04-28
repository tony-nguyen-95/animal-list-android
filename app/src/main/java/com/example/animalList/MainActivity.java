package com.example.animalList;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        setContentView(R.layout.button_toast);

        Button clickMe = findViewById(R.id.click_me);
        Button emptyButton = findViewById(R.id.empty_button);

        clickMe.setOnClickListener(v -> {
            Toast.makeText(this, "Clicked me", Toast.LENGTH_SHORT).show();
        });

        emptyButton.setOnClickListener(v->{
            Toast.makeText(this, "Empty button", Toast.LENGTH_SHORT).show();
        });

    }

}