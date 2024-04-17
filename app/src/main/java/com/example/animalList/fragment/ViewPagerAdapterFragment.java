package com.example.animalList.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
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
    public static ViewPagerAdapterFragment newInstance(ArrayList<Animal> animals, int position) {
        // Create a new instance of ViewPagerAdapterFragment
        ViewPagerAdapterFragment fragment = new ViewPagerAdapterFragment();

        // Create a bundle to pass the list of animals
        Bundle args = new Bundle();
        args.putSerializable("animals", animals);
        args.putSerializable("position",position);

        // Set the arguments on the fragment
        fragment.setArguments(args);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_viewpager_wrapper, container, false);

        // Retrieve the list of animals from the arguments
        ArrayList<Animal> animals = (ArrayList<Animal>) getArguments().getSerializable("animals");
        int position = getArguments().getInt("position", 0);

        DetailViewPagerAdapter adapter = new DetailViewPagerAdapter(getChildFragmentManager());

        // Create a list of AnimalDetailFragment instances
        ArrayList<AnimalDetailFragment> animalFragments = new ArrayList<>();

        for (Animal animal : animals) {
            AnimalDetailFragment fragment = AnimalDetailFragment.newInstance(animal);
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
                GridAnimalsFragment gridAnimalsFragment = GridAnimalsFragment.newInstance(animals);
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
