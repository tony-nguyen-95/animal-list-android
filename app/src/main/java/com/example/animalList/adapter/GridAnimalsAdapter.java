package com.example.animalList.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.animalList.R;
import com.example.animalList.model.Animal;

import java.util.List;

public class GridAnimalsAdapter extends  BaseAdapter {

    private Context mContext;
    private List<Animal> mAnimalList;
    private AppCompatActivity mActivity;
    private int REQUEST_CODE_DETAIL_ACTIVITY =1;

    public GridAnimalsAdapter(AppCompatActivity activity,Context context, List<Animal> animalList) {
        mActivity = activity;
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
            convertView = LayoutInflater.from(mContext).inflate(R.layout.fragment_grid_animals, parent, false);
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
                Toast.makeText(mContext, "Clicked", Toast.LENGTH_SHORT).show();
//                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.3f);
//                alphaAnimation.setDuration(600);
//                v.startAnimation(alphaAnimation);
//
//                Intent intent = new Intent(mContext, DetailActivity.class);
//                intent.putExtra("animal", animal); // pass the whole of an object
//                mActivity.startActivityForResult(intent, REQUEST_CODE_DETAIL_ACTIVITY);
//                mActivity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        return convertView;
    }

}