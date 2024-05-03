package com.example.animalList.model;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.animalList.R;

public class StoryViewHolder extends RecyclerView.ViewHolder {
    private TextView storyTitleTextView;
    private TextView storyDetailTextView;
    private Context context;

    public StoryViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
        animalIconImageView = itemView.findViewById(R.id.imageView);
        animalNameTextView = itemView.findViewById(R.id.textView);
        lovedImageView = itemView.findViewById(R.id.lovedImage);
    }

    public void bind(Story story) {
        // Set the story name
        animalNameTextView.setText(story.getName());

        story.loadImageFromAssets(context,animalIconImageView, story.getIconImagePath());

        // Set the visibility of the loved image based on whether the story is liked
        if (story.isLiked()) {
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
