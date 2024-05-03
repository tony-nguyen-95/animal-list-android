package com.example.animalList.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.animalList.fragment.StoryDetailFragment;

import java.util.ArrayList;

public class DetailViewPagerAdapter extends FragmentPagerAdapter {
    // Initialize an empty list of fragments
    private ArrayList<StoryDetailFragment> storyFragments = new ArrayList<>();

    // Constructor takes only the FragmentManager
    public DetailViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    // Method to add a new fragment to the adapter
    public void addFragment(StoryDetailFragment fragment) {
        storyFragments.add(fragment);
        notifyDataSetChanged();
    }

    // Get the fragment at the given position
    @NonNull
    @Override
    public StoryDetailFragment getItem(int position) {
        return storyFragments.get(position);
    }

    // Return the number of fragments in the adapter
    @Override
    public int getCount() {
        return storyFragments.size();
    }
}
