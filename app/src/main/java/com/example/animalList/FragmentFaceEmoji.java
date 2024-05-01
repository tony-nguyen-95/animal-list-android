package com.example.animalList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import android.widget.GridView;

public class FragmentFaceEmoji extends Fragment {

    private GridView mGridView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_emoji_grid, container, false);

        // Initialize the GridView
        mGridView = rootView.findViewById(R.id.grid_view);
        GridViewAdapter adapter = new GridViewAdapter(getContext());
        mGridView.setAdapter(adapter);

        return rootView;
    }
}
