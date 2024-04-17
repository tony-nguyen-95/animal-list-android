package com.example.animalList.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
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
            // Create an AlphaAnimation instance to animate the transparency
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.2f);
            alphaAnimation.setDuration(150);

            // Start the animation on the item view
            v.startAnimation(alphaAnimation);

            // Assuming mContext is an AppCompatActivity or can be cast to it
            AppCompatActivity appActivity = (AppCompatActivity) mContext;

            // Replace ViewPagerAdapterFragment
            ViewPagerAdapterFragment viewPagerAdapterFragment = ViewPagerAdapterFragment.newInstance(mAnimalList, position);

            // Begin the fragment transaction
            FragmentTransaction transaction = appActivity.getSupportFragmentManager().beginTransaction();

            // Set custom animations, tween (flip)
            transaction.setCustomAnimations(R.anim.flip_in, R.anim.flip_out);

            // Replace fragment and add to back stack
            transaction.replace(R.id.ln_main, viewPagerAdapterFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        });
    }


    @Override
    public int getItemCount() {
        return mAnimalList.size();
    }
}
