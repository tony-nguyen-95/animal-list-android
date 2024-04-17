package com.example.animalList.model;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.animalList.R;

public class AnimalViewHolder extends RecyclerView.ViewHolder {
    // Declare views in the item layout
    private ImageView animalIconImageView;
    private TextView animalNameTextView;
    private ImageView lovedImageView;

    public AnimalViewHolder(View itemView) {
        super(itemView);
        // Initialize views from the item layout
        animalIconImageView = itemView.findViewById(R.id.imageView); // Reference to the icon ImageView
        animalNameTextView = itemView.findViewById(R.id.textView); // Reference to the name TextView
        lovedImageView = itemView.findViewById(R.id.lovedImage); // Reference to the loved ImageView
    }

    // Method to bind data to the views
    public void bind(Animal animal) {
        // Set the animal icon and name
        animalIconImageView.setImageResource(animal.getIconImage());
        animalNameTextView.setText(animal.getName());

        // Set the visibility of the loved image based on whether the animal is liked
        if (animal.isLiked()) {
            lovedImageView.setVisibility(View.VISIBLE);
        } else {
            lovedImageView.setVisibility(View.INVISIBLE);
        }
    }

    // Getters for accessing the views outside of the view holder
    public ImageView getAnimalIconImageView() {
        return animalIconImageView;
    }

    public TextView getAnimalNameTextView() {
        return animalNameTextView;
    }

    public ImageView getLovedImageView() {
        return lovedImageView;
    }
}
