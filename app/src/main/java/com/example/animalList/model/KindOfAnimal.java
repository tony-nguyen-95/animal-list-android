package com.example.animalList.model;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

public class KindOfAnimal {

    public String name;
    public int photo;
    public ArrayList<Animal> listRepresent;

    public KindOfAnimal(String name, int photo)
        {
            this.name = name;
            this.photo = photo;
//            this.listRepresent = listRepresent;
        }


}
