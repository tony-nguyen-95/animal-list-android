package com.example.animalList;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.animalList.model.Animal;

public class DetailActivity extends AppCompatActivity {
    boolean isLoved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        Animal animal = (Animal) intent.getSerializableExtra("animal");

        TextView nameTextView = findViewById(R.id.animalNameTextView);
        ImageView imageDetailView = findViewById(R.id.animalImageView);
        TextView descriptionTextView = findViewById(R.id.descriptionTextView);
        ImageButton loveButton = findViewById(R.id.loveButton);

        assert animal != null;

        this.isLoved = animal.isLiked();

        if(isLoved){
            loveButton.setImageResource(R.drawable.ic_heart_filled);
        }else {
            loveButton.setImageResource(R.drawable.ic_heart);
        }

        loveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isLoved = !isLoved; // Toggle the loved state
                if (isLoved) {
                    loveButton.setImageResource(R.drawable.ic_heart_filled); // Change to filled heart
                } else {
                    loveButton.setImageResource(R.drawable.ic_heart); // Change to outline heart
                }
                animal.setLiked(isLoved);
                Intent resultIntent = new Intent();
                resultIntent.putExtra("updated_animal", animal);
                setResult(RESULT_OK, resultIntent);
            }
        });

        imageDetailView.setImageResource(animal.getImage());
        nameTextView.setText(animal.getName());
        descriptionTextView.setText(animal.getDescription());

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Back To List");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);

        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });


    }


}