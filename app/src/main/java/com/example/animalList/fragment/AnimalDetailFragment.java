package com.example.animalList.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.animalList.R;
import com.example.animalList.adapter.DetailViewPagerAdapter;
import com.example.animalList.model.Animal;
import com.example.animalList.model.KindOfAnimal;

import java.io.Serializable;

public class AnimalDetailFragment extends Fragment implements Serializable {
    private static final String ARG_ANIMAL = "animal";
    private Animal animal;
    private DetailViewPagerAdapter detailViewPagerAdapter;

    // Private constructor to prevent direct instantiation
    private AnimalDetailFragment() {}

    public void setDetailViewPagerAdapter(DetailViewPagerAdapter adapter) {
        this.detailViewPagerAdapter = adapter;
    }
    public static AnimalDetailFragment newInstance(Animal animal){
        AnimalDetailFragment fragment = new AnimalDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_ANIMAL, animal);
        fragment.setArguments(args);
        return  fragment;
    }

    @Override
    public  void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        // Retrieve arguments and initialize animal
        if (getArguments() != null) {
            animal = (Animal) getArguments().getSerializable(ARG_ANIMAL);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail_item, container, false);

        // Retrieve the views from the layout
        TextView nameTextView = view.findViewById(R.id.animalNameTextView);
        ImageView imageDetailView = view.findViewById(R.id.animalImageView);
        TextView descriptionTextView = view.findViewById(R.id.descriptionTextView);
        ImageButton loveButton = view.findViewById(R.id.loveButton);

        // Check if the animal data is available
        if (animal != null) {
            // Set the text and image based on the animal data
            nameTextView.setText(animal.getName());
            imageDetailView.setImageResource(animal.getIconImage());
            descriptionTextView.setText(animal.getDescription());

            // Set the state of the love button
            if (animal.isLiked()) {
                loveButton.setImageResource(R.drawable.ic_heart_filled);
            } else {
                loveButton.setImageResource(R.drawable.ic_heart);
            }

            // Set an OnClickListener on the love button
            loveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Toggle the isLiked property of the current animal
                    animal.setLiked(!animal.isLiked());

                    // Update the icon of the love button based on the new isLiked state
                    if (animal.isLiked()) {
                        loveButton.setImageResource(R.drawable.ic_heart_filled);
                    } else {
                        loveButton.setImageResource(R.drawable.ic_heart);
                    }

                    // Check if the adapter is not null
                    if (detailViewPagerAdapter != null) {
                        // Notify the adapter that the data set has changed
                        detailViewPagerAdapter.notifyDataSetChanged();
                    }
                }
            });
        }

        // Return the inflated view
        return view;
    }




}
