package com.example.animalList.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.animalList.fragment.AnimalDetailFragment;

import java.util.ArrayList;

public class DetailViewPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<AnimalDetailFragment> animalFragments = new ArrayList<>();

    public DetailViewPagerAdapter(ArrayList<AnimalDetailFragment> animalFragments, @NonNull FragmentManager fm) {
        super(fm);
        this.animalFragments = animalFragments;
    }

    @NonNull
    @Override
    public AnimalDetailFragment getItem(int position) {
        return animalFragments.get(position);
    }

    @Override
    public int getCount() {
        return animalFragments.size();
    }

}
