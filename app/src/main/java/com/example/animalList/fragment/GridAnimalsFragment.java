package com.example.animalList.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animalList.R;
import com.example.animalList.adapter.GridAnimalsAdapter;
import com.example.animalList.model.Animal;
import com.example.animalList.model.KindOfAnimal;

import java.util.ArrayList;

public class GridAnimalsFragment extends Fragment {

    private static final String ARG_KIND_OF_ANIMAL = "kind_of_animal";
    private ArrayList<Animal> animals;

    // Private constructor to prevent direct instantiation
    private GridAnimalsFragment() {}

    public static GridAnimalsFragment newInstance(ArrayList<Animal> animals) {
        GridAnimalsFragment fragment = new GridAnimalsFragment();
        Bundle args = new Bundle();
        args.putSerializable("animals", animals);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Retrieve arguments and initialize kindOfAnimal
        if (getArguments() != null) {
            animals = (ArrayList<Animal>) getArguments().getSerializable("animals");
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_grid_animals, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.grid_animals);

        // Set up a GridLayoutManager with 3 columns
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        recyclerView.setLayoutManager(gridLayoutManager);

        // Create an instance of your AnimalAdapter
        GridAnimalsAdapter animalAdapter = new GridAnimalsAdapter(getContext(),animals);

        // Set the adapter on the RecyclerView
        recyclerView.setAdapter(animalAdapter);

        return view;
    }
}
