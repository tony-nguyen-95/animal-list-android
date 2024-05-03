package com.example.animalList.fragment;

import android.content.Context;
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
import com.example.animalList.model.Story;

import java.io.Serializable;

public class StoryDetailFragment extends Fragment {
    private static final String ARG_STORY = "story";
    private Story story;
    private Context mContext;
    public StoryDetailFragment(Story story) {
        this.story = story;
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_detail_story, container, false);
        TextView nameTextView = view.findViewById(R.id.tv_name);
        TextView descriptionTextView = view.findViewById(R.id.tv_content);

        if (story != null) {
            nameTextView.setText(story.getmTitle());
            descriptionTextView.setText(story.getmDetail());}

        return view;
    }
}
