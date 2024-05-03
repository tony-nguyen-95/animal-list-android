package com.example.animalList.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animalList.R;
import com.example.animalList.fragment.ListStoriesFragment;
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

        viewHolder.getView().setOnClickListener(v -> {
            ListStoriesFragment listStoriesFragment = new ListStoriesFragment(currentKindOfStory);
            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            activity.getSupportFragmentManager().beginTransaction()
                    .replace(R.id.ln_main, listStoriesFragment)
                    .addToBackStack(null)
                    .commit();
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
