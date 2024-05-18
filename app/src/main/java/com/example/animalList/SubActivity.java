package com.example.animalList;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        textView = findViewById(R.id.textView);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String receivedText = intent.getStringExtra("inputString");

        // Set the string in TextView
        textView.setText(receivedText);
    }
}