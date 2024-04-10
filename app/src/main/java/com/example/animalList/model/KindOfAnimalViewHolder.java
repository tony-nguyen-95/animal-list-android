package com.example.animalList.model;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.animalList.R;

public class KindOfAnimalViewHolder extends RecyclerView.ViewHolder {
    private TextView kindName;
    private ImageView kindPhoto;
    private   View view;

    public  KindOfAnimalViewHolder(View itemView){
        super(itemView);
        kindName = itemView.findViewById(R.id.kindAnimalName);
        kindPhoto = itemView.findViewById(R.id.kindAnimalPhoto);
        view = itemView;
    }

    public TextView getKindName() {
        return kindName;
    }

    public void setKindName(TextView kindName) {
        this.kindName = kindName;
    }

    public ImageView getKindPhoto() {
        return kindPhoto;
    }

    public void setKindPhoto(ImageView kindPhoto) {
        this.kindPhoto = kindPhoto;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
}
