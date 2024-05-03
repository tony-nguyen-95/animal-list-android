package com.example.animalList.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animalList.R;
import com.example.animalList.fragment.GridAnimalsFragment;
import com.example.animalList.model.KindOfStory;
import com.example.animalList.model.KindOfStoryViewHolder;

import java.util.Collections;
import java.util.List;

public class KindOfStoryAdapter extends RecyclerView.Adapter<KindOfStoryViewHolder> {

    private List<KindOfStory> list = Collections.emptyList();
    private AppCompatActivity appCompatActivity;

    public KindOfStoryAdapter(List<KindOfStory> list, AppCompatActivity appCompatActivity) {
        this.list = list;
        this.appCompatActivity = appCompatActivity;
    }

    @Override
    public KindOfStoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.kind_stories_recycle_menu_item, parent, false);
        return new KindOfStoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(KindOfStoryViewHolder viewHolder, final int position) {
        final KindOfStory currentKindOfStory = list.get(position);

        // Set the name and photo for the current kind of animal
        viewHolder.getKindName().setText(currentKindOfStory.getName());
        viewHolder.getKindPhoto().setImageDrawable(currentKindOfStory.getPhoto());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
