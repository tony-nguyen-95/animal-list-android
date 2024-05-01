package com.example.animalList;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate FragmentFaceEmoji
        FragmentFaceEmoji fragmentFaceEmoji = new FragmentFaceEmoji();

        // Begin a transaction to replace the fragment container with FragmentFaceEmoji
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragmentFaceEmoji)
                .commit();
    }
}
