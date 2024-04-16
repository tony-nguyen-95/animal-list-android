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
import com.example.animalList.fragment.MenuFragment;
import com.example.animalList.fragment.ViewPagerAdapterFragment;
import com.example.animalList.model.Animal;

import java.util.ArrayList;
import java.util.List;

public class GridAnimalsAdapter extends  BaseAdapter {

    private Context mContext;
    private ArrayList<Animal> mAnimalList;

    private int REQUEST_CODE_DETAIL_ACTIVITY =1;

    public GridAnimalsAdapter(Context context, ArrayList<Animal> animalList) {
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

                // Replace ViewPagerAdapter
                ViewPagerAdapterFragment viewPagerAdapterFragment = ViewPagerAdapterFragment.newInstance(mAnimalList);
                appActivity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.ln_main, viewPagerAdapterFragment, null)
                        .commit();

            }
        });



        return convertView;
    }

}