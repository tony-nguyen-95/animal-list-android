package com.example.animalList.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.animalList.R;
import com.example.animalList.fragment.AnimalDetailFragment;
import com.example.animalList.model.Animal;

import java.util.ArrayList;
import java.util.List;

public class GridAnimalsAdapter extends  BaseAdapter {

    private Context mContext;
    private List<Animal> mAnimalList;

    private int REQUEST_CODE_DETAIL_ACTIVITY =1;

    public GridAnimalsAdapter(Context context, List<Animal> animalList) {
        mContext = context;
        mAnimalList = animalList;

    }

    @Override
    public int getCount() {
        return mAnimalList.size();
    }

    @Override
    public Object getItem(int position) {
        return mAnimalList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.grid_animal_item, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView textView = convertView.findViewById(R.id.textView);
        ImageView lovedImage = convertView.findViewById(R.id.lovedImage);

        final Animal animal = mAnimalList.get(position);
        if(animal.isLiked()){
            lovedImage.setVisibility(View.VISIBLE);
        }else {
            lovedImage.setVisibility(View.INVISIBLE);
        }

        imageView.setImageResource(animal.getIconImage());
        textView.setText(animal.getName());


        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Assuming mContext is an AppCompatActivity or can be cast to it
                AppCompatActivity appActivity = (AppCompatActivity) mContext;

                // Create a list of AnimalDetailFragment based on the list of animals
                ArrayList<AnimalDetailFragment> animalFragments = new ArrayList<>();
                for (Animal animal : mAnimalList) {
                    AnimalDetailFragment fragment = AnimalDetailFragment.newInstance(animal);
                    animalFragments.add(fragment);
                }

                // Create a new instance of DetailViewPagerAdapter with the list of AnimalDetailFragment and FragmentManager
                DetailViewPagerAdapter detailViewPagerAdapter = new DetailViewPagerAdapter(animalFragments, appActivity.getSupportFragmentManager());

                // Begin a fragment transaction
                FragmentTransaction transaction = appActivity.getSupportFragmentManager().beginTransaction();

                // Create an instance of AnimalDetailFragment using the clicked animal
                AnimalDetailFragment animalDetailFragment = AnimalDetailFragment.newInstance(animal);

                // Replace the current fragment with the new AnimalDetailFragment
                transaction.replace(R.id.ln_main, animalDetailFragment); // Update 'fragment_container' to match the ID of the container where the new fragment should be placed

                // Commit the transaction
                transaction.commit();
            }
        });



        return convertView;
    }

}