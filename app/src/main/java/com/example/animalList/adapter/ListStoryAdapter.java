package com.example.animalList.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animalList.R;
import com.example.animalList.fragment.ViewPagerAdapterFragment;
import com.example.animalList.model.KindOfStory;
import com.example.animalList.model.Story;
import com.example.animalList.model.StoryViewHolder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListStoryAdapter extends RecyclerView.Adapter<StoryViewHolder> {

    private KindOfStory kindOfStory;
    private Context context;

    public ListStoryAdapter(KindOfStory kindOfStory, Context context) {
        this.kindOfStory = kindOfStory;
        this.context = context;
    }

    @Override
    public StoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.story_list_item, parent, false);
        return new StoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StoryViewHolder viewHolder, final int position) {
        final Story currentStory = kindOfStory.getListStory().get(position);

        AppCompatActivity appActivity = (AppCompatActivity) context;

        // Bind data to the StoryViewHolder
        viewHolder.bind(currentStory);

        // Set onClickListener for the ViewHolder if needed
        viewHolder.itemView.setOnClickListener(v -> {

            // Replace ViewPagerAdapterFragment
            ViewPagerAdapterFragment viewPagerAdapterFragment = ViewPagerAdapterFragment.newInstance(kindOfStory, position);
            // Begin the fragment transaction
            FragmentTransaction transaction = appActivity.getSupportFragmentManager().beginTransaction();

            // Replace fragment and add to back stack
            transaction.replace(R.id.ln_main, viewPagerAdapterFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        });
    }

    @Override
    public int getItemCount() {
        return kindOfStory.getListStory().size();
    }
}
