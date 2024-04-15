package com.example.animalList.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.animalList.R;
import com.example.animalList.adapter.GridAnimalsAdapter;
import com.example.animalList.model.KindOfAnimal;

public class GridAnimalsFragment extends Fragment {

    private static final String ARG_KIND_OF_ANIMAL = "kind_of_animal";
    private KindOfAnimal kindOfAnimal;

    // Private constructor to prevent direct instantiation
    private GridAnimalsFragment() {}

    public static GridAnimalsFragment newInstance(KindOfAnimal kindOfAnimal) {
        GridAnimalsFragment fragment = new GridAnimalsFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_KIND_OF_ANIMAL, kindOfAnimal);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Retrieve arguments and initialize kindOfAnimal
        if (getArguments() != null) {
            kindOfAnimal = (KindOfAnimal) getArguments().getSerializable(ARG_KIND_OF_ANIMAL);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_grid_animals, container, false);

        GridView gridView = view.findViewById(R.id.grid_animals);

        if (kindOfAnimal != null && kindOfAnimal.getListRepresent() != null) {
            // Create an instance of GridAnimalsAdapter
            GridAnimalsAdapter gridAnimalsAdapter = new GridAnimalsAdapter(getContext(), kindOfAnimal.getListRepresent());

            // Set the adapter to the GridView
            gridView.setAdapter(gridAnimalsAdapter);
        }

        return view;
    }
}
