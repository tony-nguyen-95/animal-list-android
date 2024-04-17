package com.example.animalList.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animalList.R;
import com.example.animalList.adapter.KindOfAnimalAdapter;
import com.example.animalList.data.AnimalsData;
import com.example.animalList.model.Animal;
import com.example.animalList.model.KindOfAnimal;

import java.util.ArrayList;
import java.util.List;

public class MenuFragment extends Fragment {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Context mContext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_menu, container, false);
        initView(v);
        return v;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    private void initView(View v) {
        // Set up the toolbar as the support action bar
        Toolbar toolbar = v.findViewById(R.id.toolbar);
        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();

        if (appCompatActivity != null) {
            // Set the toolbar as the support action bar
            appCompatActivity.setSupportActionBar(toolbar);

            // Initialize the DrawerLayout and ActionBarDrawerToggle
            drawerLayout = v.findViewById(R.id.drawer);
            actionBarDrawerToggle = new ActionBarDrawerToggle(appCompatActivity, drawerLayout, toolbar, R.string.nav_open, R.string.nav_close);
            drawerLayout.addDrawerListener(actionBarDrawerToggle);
            actionBarDrawerToggle.syncState();

            // Get the ActionBar from the activity
            ActionBar actionBar = appCompatActivity.getSupportActionBar();

            // Set the title and display home button
            if (actionBar != null) {
                actionBar.setTitle("Navigation");
                actionBar.setDisplayShowHomeEnabled(true);
            }
        }


        List<KindOfAnimal> list = new ArrayList<>();
        list = getDataKindOfAnimal();

        // Find the RecyclerView within the nav header layout
        RecyclerView recyclerView = v.findViewById(R.id.recyclerView);

        // Set up RecyclerView
        KindOfAnimalAdapter adapter = new KindOfAnimalAdapter(list,appCompatActivity);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));

    }

    private List<KindOfAnimal> getDataKindOfAnimal()
    {
        List<KindOfAnimal> list = new ArrayList<>();

        list.add(new KindOfAnimal("Seas", R.drawable.animal_oceans, AnimalsData.getInstance(mContext).getSeaAnimals()));
        list.add(new KindOfAnimal("Mammals", R.drawable.animal_mammals, AnimalsData.getInstance(mContext).getMammals()));
        list.add(new KindOfAnimal("Birds", R.drawable.animals_birds, AnimalsData.getInstance(mContext).getBirds()));

        return list;
    }

}
