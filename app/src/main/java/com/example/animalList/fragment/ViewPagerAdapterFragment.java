package com.example.animalList.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.animalList.R;
import com.example.animalList.adapter.DetailViewPagerAdapter;
import com.example.animalList.model.Animal;

import java.util.ArrayList;
public class ViewPagerAdapterFragment extends Fragment {
    private ViewPager viewPager;
    private Context mContext;
    private ArrayList<AnimalDetailFragment> animalFragments;

    // Create a new instance of ViewPagerAdapterFragment with animalFragments as a parameter
    public static ViewPagerAdapterFragment newInstance(ArrayList<Animal> animals) {
        // Create a new instance of ViewPagerAdapterFragment
        ViewPagerAdapterFragment fragment = new ViewPagerAdapterFragment();

        // Create a bundle to pass the list of animals
        Bundle args = new Bundle();
        args.putSerializable("animals", animals);

        // Set the arguments on the fragment
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_viewpager_wrapper, container, false);

        // Retrieve the list of animals from the arguments
        if (getArguments() != null) {
            ArrayList<Animal> animals = (ArrayList<Animal>) getArguments().getSerializable("animals");

            // Create a list of AnimalDetailFragment instances
            ArrayList<AnimalDetailFragment> animalFragments = new ArrayList<>();
            for (Animal animal : animals) {
                animalFragments.add(AnimalDetailFragment.newInstance(animal));
            }

            // Initialize ViewPager
            viewPager = view.findViewById(R.id.viewpagerDetail);

            // Create and set the adapter for the ViewPager
            DetailViewPagerAdapter adapter = new DetailViewPagerAdapter(animalFragments, getChildFragmentManager());
            viewPager.setAdapter(adapter);
        }

        return view;
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }
}
