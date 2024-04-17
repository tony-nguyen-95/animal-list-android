package com.example.animalList.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animalList.R;
import com.example.animalList.fragment.ViewPagerAdapterFragment;
import com.example.animalList.model.Animal;
import com.example.animalList.model.AnimalViewHolder;

import java.util.ArrayList;

public class GridAnimalsAdapter extends RecyclerView.Adapter<AnimalViewHolder> {

    private Context mContext;
    private ArrayList<Animal> mAnimalList;

    public GridAnimalsAdapter(Context context, ArrayList<Animal> animalList) {
        this.mContext = context;
        this.mAnimalList = animalList;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for the animal item
        View view = LayoutInflater.from(mContext).inflate(R.layout.grid_animal_item, parent, false);
        return new AnimalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        // Bind the data for the animal at the given position
        Animal animal = mAnimalList.get(position);
        holder.bind(animal);

        // Set the click listener for the animal item
        holder.itemView.setOnClickListener(v -> {
            // Assuming mContext is an AppCompatActivity or can be cast to it
            AppCompatActivity appActivity = (AppCompatActivity) mContext;

            // Replace ViewPagerAdapter
            ViewPagerAdapterFragment viewPagerAdapterFragment = ViewPagerAdapterFragment.newInstance(mAnimalList, position);
            appActivity.getSupportFragmentManager().beginTransaction()
                    .replace(R.id.ln_main, viewPagerAdapterFragment)
                    .addToBackStack(null)
                    .commit();
        });
    }

    @Override
    public int getItemCount() {
        return mAnimalList.size();
    }
}
