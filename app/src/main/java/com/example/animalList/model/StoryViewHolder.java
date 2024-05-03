package com.example.animalList.model;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animalList.R;
import com.example.animalList.model.Story;

public class StoryViewHolder extends RecyclerView.ViewHolder {

    private TextView titleTextView;

    public StoryViewHolder(@NonNull View itemView) {
        super(itemView);
        titleTextView = itemView.findViewById(R.id.tv_story);
    }

    public void bind(Story story) {
        titleTextView.setText(story.getmTitle());
    }
}
