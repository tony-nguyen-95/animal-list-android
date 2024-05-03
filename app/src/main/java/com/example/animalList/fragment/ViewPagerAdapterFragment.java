package com.example.animalList.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.animalList.R;
import com.example.animalList.adapter.DetailViewPagerAdapter;
import com.example.animalList.model.Story;

import java.util.ArrayList;
public class ViewPagerAdapterFragment extends Fragment {
    private ViewPager viewPager;
    private Context mContext;
    private ArrayList<AnimalDetailFragment> animalFragments;

    // Create a new instance of ViewPagerAdapterFragment with animalFragments as a parameter
    public static ViewPagerAdapterFragment newInstance(ArrayList<Story> stories, int position) {
        // Create a new instance of ViewPagerAdapterFragment
        ViewPagerAdapterFragment fragment = new ViewPagerAdapterFragment();

        // Create a bundle to pass the list of stories
        Bundle args = new Bundle();
        args.putSerializable("stories", stories);
        args.putSerializable("position",position);

        // Set the arguments on the fragment
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_viewpager_wrapper, container, false);

        // Retrieve the list of stories from the arguments
        ArrayList<Story> stories = (ArrayList<Story>) getArguments().getSerializable("stories");
        int position = getArguments().getInt("position", 0);

        DetailViewPagerAdapter adapter = new DetailViewPagerAdapter(getChildFragmentManager());

        // Create a list of AnimalDetailFragment instances
        ArrayList<AnimalDetailFragment> animalFragments = new ArrayList<>();

        for (Story story : stories) {
            AnimalDetailFragment fragment = AnimalDetailFragment.newInstance(story);
            adapter.addFragment(fragment);
            fragment.setDetailViewPagerAdapter(adapter);
        }

        // Initialize ViewPager
        viewPager = view.findViewById(R.id.viewpagerDetail);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(position);

        // Initialize the toolbar
        Toolbar toolbar = view.findViewById(R.id.toolbar_detail);
        toolbar.setTitle("Back To List");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);

        // Set the toolbar as the action bar for the activity
        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        appCompatActivity.setSupportActionBar(toolbar);

        // Set the navigation click listener to handle back navigation
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Use the fragment manager to navigate back
                appCompatActivity.getSupportFragmentManager().popBackStack();

                // Re-render grid list
                GridAnimalsFragment gridAnimalsFragment = GridAnimalsFragment.newInstance(stories);
                FragmentTransaction transaction = appCompatActivity.getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_grid_animals, gridAnimalsFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return view;
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }
}
