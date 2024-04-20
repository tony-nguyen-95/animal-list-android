package com.example.animalList.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.animalList.R;
import com.example.animalList.adapter.DetailViewPagerAdapter;
import com.example.animalList.adapter.GridAnimalsAdapter;
import com.example.animalList.data.AnimalsData;
import com.example.animalList.model.Animal;
import com.example.animalList.model.KindOfAnimal;

import java.io.Serializable;
import java.util.ArrayList;

public class AnimalDetailFragment extends Fragment implements Serializable {
    private static final String ARG_ANIMAL = "animal";
    private Animal animal;
    private DetailViewPagerAdapter detailViewPagerAdapter;
    private GridAnimalsAdapter gridAnimalsAdapter;


    // Private constructor to prevent direct instantiation
    private AnimalDetailFragment() {}

    public void setDetailViewPagerAdapter(DetailViewPagerAdapter adapter) {
        this.detailViewPagerAdapter = adapter;
    }
    public void setGridAnimalsAdapter(GridAnimalsAdapter gridAdapter) {
        this.gridAnimalsAdapter = gridAdapter;
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
        ImageButton phoneButton = view.findViewById(R.id.phoneButton);

        // Check if the animal data is available
        if (animal != null) {
            // Set the text and image based on the animal data
            nameTextView.setText(animal.getName());
            imageDetailView.setImageResource(animal.getImage());
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

                    // Save the loved state of the animal
                    AppCompatActivity compatActivity = (AppCompatActivity) getActivity();
                    AnimalsData.getInstance(compatActivity).saveLovedState(animal);

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

            phoneButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Create an AlertDialog to show the pop-up form
                    AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());

                    // Inflate the custom form layout
                    LayoutInflater formInflater = LayoutInflater.from(requireContext());
                    View formView = formInflater.inflate(R.layout.dialog_form, null);

                    // Set the form view as the content of the dialog
                    builder.setView(formView);

                    // Configure the dialog's buttons and views
                    EditText inputField = formView.findViewById(R.id.inputField);
                    Button submitButton = formView.findViewById(R.id.submitButton);

                    AlertDialog dialog = builder.create();


                    // Define actions for the buttons
                    submitButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // Handle form submission
                            String userInput = inputField.getText().toString();
                            Toast.makeText(requireContext(), "Form submitted: " + userInput, Toast.LENGTH_SHORT).show();
                            // Dismiss the dialog after form submission
                            dialog.dismiss();
                        }
                    });

                    // Create and show the dialog
                    dialog.show();
                }
            });
        }



        // Return the inflated view
        return view;
    }




}
