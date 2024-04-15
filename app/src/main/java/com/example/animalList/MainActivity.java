package com.example.animalList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animalList.adapter.KindOfAnimalAdapter;
import com.example.animalList.fragment.GridAnimalsFragment;
import com.example.animalList.model.KindOfAnimal;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up the toolbar as the support action bar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        // calling this activity's function to
        // use ActionBar utility methods
        ActionBar actionBar = getSupportActionBar();

        // providing title for the ActionBar
        actionBar.setTitle("Navigation");

        actionBar.setDisplayShowHomeEnabled(true);

        List<KindOfAnimal> list = new ArrayList<>();
        list = getDataKindOfAnimal();

        // Find the RecyclerView within the nav header layout
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        // Set up RecyclerView
        KindOfAnimalAdapter adapter = new KindOfAnimalAdapter(list, getApplication());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }



    // Sample data for RecyclerView
    private List<KindOfAnimal> getDataKindOfAnimal()
    {
        List<KindOfAnimal> list = new ArrayList<>();
        list.add(new KindOfAnimal("Seas", R.drawable.animal_oceans));
        list.add(new KindOfAnimal("Mammals", R.drawable.animal_mammals));
        list.add(new KindOfAnimal("Birds", R.drawable.animals_birds));

        return list;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Handle the action bar drawer toggle
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        System.out.println(item.getItemId());

        DrawerLayout drawerLayout = findViewById(R.id.my_drawer_layout); // Adjust the ID of the drawer layout if necessary
        drawerLayout.closeDrawer(GravityCompat.START);

        GridAnimalsFragment gridAnimalsFragment = GridAnimalsFragment.newInstance(new KindOfAnimal("Mammals", R.drawable.animal_mammals));
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_grid_animals, gridAnimalsFragment); // Replace "fragment_container" with the ID of your fragment container
        transaction.addToBackStack(null); // Add to back stack if you want to handle back navigation
        transaction.commit();

        return true;


    }


}
