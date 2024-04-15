package com.example.animalList.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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

    List<KindOfAnimal> list = Collections.emptyList();
    AppCompatActivity appContext;

    public KindOfAnimalAdapter(List<KindOfAnimal> list, Context context,AppCompatActivity appContext )
    {
        this.list = list;
        this.appContext = appContext;
    }

    @Override
    public KindOfAnimalViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        Context context = parent.getContext();
        LayoutInflater inflater  = LayoutInflater.from(context);

        View photoView
                = inflater
                .inflate(R.layout.kind_animal_recycle_item, parent, false);

        KindOfAnimalViewHolder viewHolder = new KindOfAnimalViewHolder(photoView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(KindOfAnimalViewHolder viewHolder, final int position) {
        // Get the KindOfAnimal object for the current position
        final KindOfAnimal currentKindOfAnimal = list.get(position);

        // Set the text and image for the view holder
        viewHolder.getKindName().setText(currentKindOfAnimal.name);
        viewHolder.getKindPhoto().setImageResource(currentKindOfAnimal.photo);

        // Set the click listener
        viewHolder.getView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Close the drawer
                DrawerLayout drawerLayout = view.getRootView().findViewById(R.id.my_drawer_layout);
                drawerLayout.closeDrawer(GravityCompat.START);

                // Create an instance of GridAnimalsFragment with the current KindOfAnimal object
                GridAnimalsFragment gridAnimalsFragment = GridAnimalsFragment.newInstance(currentKindOfAnimal);

                System.out.println(currentKindOfAnimal);

                // Start a fragment transaction
                FragmentTransaction transaction = appContext.getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_grid_animals, gridAnimalsFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }


}
