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
import androidx.fragment.app.Fragment;

import com.example.animalList.R;
import com.example.animalList.adapter.DetailViewPagerAdapter;
import com.example.animalList.data.StoriesData;
import com.example.animalList.model.Story;

import java.io.Serializable;

public class AnimalDetailFragment extends Fragment implements Serializable {
    private static final String ARG_ANIMAL = "story";
    private Story story;
    private DetailViewPagerAdapter detailViewPagerAdapter;

    // Private constructor to prevent direct instantiation
    private AnimalDetailFragment() {}

    public void setDetailViewPagerAdapter(DetailViewPagerAdapter adapter) {
        this.detailViewPagerAdapter = adapter;
    }

    public static AnimalDetailFragment newInstance(Story story) {
        AnimalDetailFragment fragment = new AnimalDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_ANIMAL, story);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            story = (Story) getArguments().getSerializable(ARG_ANIMAL);
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_item, container, false);
        TextView nameTextView = view.findViewById(R.id.animalNameTextView);
        ImageView imageDetailView = view.findViewById(R.id.animalImageView);
        TextView descriptionTextView = view.findViewById(R.id.descriptionTextView);
        ImageButton loveButton = view.findViewById(R.id.loveButton);
        ImageButton phoneButton = view.findViewById(R.id.phoneButton);
        TextView phoneNumber = view.findViewById(R.id.phoneNumber);

        if (story != null) {
            nameTextView.setText(story.getName());
            story.loadImageFromAssets(getContext(), imageDetailView, story.getImagePath());
            story.loadDescriptionFromAssets(getContext(), descriptionTextView, story.getDescriptionPath());

            if (story.isLiked()) {
                loveButton.setImageResource(R.drawable.ic_heart_filled);
            } else {
                loveButton.setImageResource(R.drawable.ic_heart);
            }

            loveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    story.setLiked(!story.isLiked());
                    AppCompatActivity compatActivity = (AppCompatActivity) getActivity();
                    StoriesData.getInstance(compatActivity).saveLovedState(story);
                    if (story.isLiked()) {
                        loveButton.setImageResource(R.drawable.ic_heart_filled);
                    } else {
                        loveButton.setImageResource(R.drawable.ic_heart);
                    }
                }
            });

            if (story.getPhoneNumber() != null) {
                phoneNumber.setVisibility(View.VISIBLE);
                phoneNumber.setText(story.getPhoneNumber());
            }

            phoneButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
                    LayoutInflater formInflater = LayoutInflater.from(requireContext());
                    View formView = formInflater.inflate(R.layout.dialog_form, null);
                    builder.setView(formView);

                    ImageView formImageTitle = formView.findViewById(R.id.formImageTitle);
                    story.loadImageFromAssets(getContext(),formImageTitle, story.getIconImagePath());
//                    formImageTitle.setImageResource(story.getIconImage());

                    EditText inputField = formView.findViewById(R.id.inputField);
                    Button submitButton = formView.findViewById(R.id.saveButton);
                    Button deleteButton = formView.findViewById(R.id.deleteButton);

                    if (story.getPhoneNumber() != null) {
                        inputField.setText(story.getPhoneNumber());
                    }

                    AlertDialog dialog = builder.create();

                    submitButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String _phoneNumber = inputField.getText().toString();
                            story.setPhoneNumber(_phoneNumber);
                            StoriesData.getInstance(getContext()).savePhoneNumber(story.getId(), _phoneNumber);
                            phoneNumber.setText(_phoneNumber);
                            phoneNumber.setVisibility(View.VISIBLE);
                            Toast.makeText(requireContext(), "Phone number saved: " + _phoneNumber, Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    });

                    deleteButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            story.setPhoneNumber(null);
                            phoneNumber.setText(null);
                            phoneNumber.setVisibility(View.INVISIBLE);
                            StoriesData.getInstance(getContext()).removePhoneNumber(story.getId());
                            Toast.makeText(requireContext(), "Phone number deleted", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                    });

                    dialog.show();
                }
            });

            if (detailViewPagerAdapter != null) {
                detailViewPagerAdapter.notifyDataSetChanged();
            }
        }

        return view;
    }
}
