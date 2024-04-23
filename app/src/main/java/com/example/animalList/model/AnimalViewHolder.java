package com.example.animalList.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.animalList.model.Animal;
import com.example.animalList.R;

public class AnimalViewHolder extends RecyclerView.ViewHolder {
    private ImageView animalIconImageView;
    private TextView animalNameTextView;
    private ImageView lovedImageView;
    private Context context;

    public AnimalViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
        animalIconImageView = itemView.findViewById(R.id.imageView);
        animalNameTextView = itemView.findViewById(R.id.textView);
        lovedImageView = itemView.findViewById(R.id.lovedImage);
    }

    public void bind(Animal animal) {
        // Set the animal name
        animalNameTextView.setText(animal.getName());

        animal.loadImageFromAssets(context,animalIconImageView, animal.getIconImagePath());

        // Set the visibility of the loved image based on whether the animal is liked
        if (animal.isLiked()) {
            lovedImageView.setVisibility(View.VISIBLE);
        } else {
            lovedImageView.setVisibility(View.INVISIBLE);
        }
    }

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
