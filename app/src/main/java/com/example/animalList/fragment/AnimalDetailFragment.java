package com.example.animalList.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.animalList.R;
import com.example.animalList.model.Animal;
import com.example.animalList.model.KindOfAnimal;

public class AnimalDetailFragment extends Fragment {
    private static final String ARG_ANIMAL = "animal";
    private Animal animal;

    // Private constructor to prevent direct instantiation
    private AnimalDetailFragment() {}

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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_detail_item, container, false);


        return view;
    }

}
