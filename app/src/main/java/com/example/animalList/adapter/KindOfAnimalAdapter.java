package com.example.animalList.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animalList.R;
import com.example.animalList.fragment.GridAnimalsFragment;
import com.example.animalList.model.KindOfAnimal;
import com.example.animalList.model.KindOfAnimalViewHolder;

import java.util.Collections;
import java.util.List;

public class KindOfAnimalAdapter extends RecyclerView.Adapter<KindOfAnimalViewHolder> {

    private List<KindOfAnimal> list = Collections.emptyList();
    private AppCompatActivity appCompatActivity;

    public KindOfAnimalAdapter(List<KindOfAnimal> list, AppCompatActivity appCompatActivity) {
        this.list = list;
        this.appCompatActivity = appCompatActivity;
    }

    @Override
    public KindOfAnimalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.kind_animal_recycle_menu_item, parent, false);
        return new KindOfAnimalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(KindOfAnimalViewHolder viewHolder, final int position) {
        final KindOfAnimal currentKindOfAnimal = list.get(position);

        // Set the name and photo for the current kind of animal
        viewHolder.getKindName().setText(currentKindOfAnimal.getName());
        viewHolder.getKindPhoto().setImageResource(currentKindOfAnimal.getPhoto());

        // Set the click listener
        viewHolder.getView().setOnClickListener(view -> {
            // Close the drawer
            DrawerLayout drawerLayout = view.getRootView().findViewById(R.id.drawer);
            drawerLayout.closeDrawer(GravityCompat.START);

            // Create an instance of GridAnimalsFragment with the current kind of animal
            GridAnimalsFragment gridAnimalsFragment = GridAnimalsFragment.newInstance(currentKindOfAnimal.getListRepresent());

            // Start a fragment transaction
            FragmentTransaction transaction = appCompatActivity.getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_grid_animals, gridAnimalsFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
