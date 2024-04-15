package com.example.animalList.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.animalList.R;
import com.example.animalList.model.KindOfAnimal;

public class GridAnimalsFragment extends Fragment {
    private static final String ARG_KIND_OF_ANIMAL = "kind_of_animal";
    private KindOfAnimal kindOfAnimal;

    // Private constructor to prevent direct instantiation
    private GridAnimalsFragment() {}

    public static GridAnimalsFragment newInstance(KindOfAnimal kindOfAnimal) {
        GridAnimalsFragment fragment = new GridAnimalsFragment();
        Bundle args = new Bundle();
        args.putSerializable("kind_of_animal", kindOfAnimal);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Retrieve arguments and initialize data
        if (getArguments() != null) {
            kindOfAnimal = (KindOfAnimal) getArguments().getSerializable(ARG_KIND_OF_ANIMAL);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_grid_animals, container, false);

        // Initialize the view (e.g., RecyclerView, GridView, etc.)
        // For example:
        // RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        // Set up the RecyclerView or other views as needed

        return view;
    }
}
