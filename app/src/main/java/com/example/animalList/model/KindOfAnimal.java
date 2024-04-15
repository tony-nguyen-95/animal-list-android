package com.example.animalList.model;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class KindOfAnimal implements Serializable {

    public String name;
    public int photo;
    public ArrayList<Animal> listRepresent;

    public KindOfAnimal(String name, int photo,ArrayList<Animal>listRepresent)
        {
            this.name = name;
            this.photo = photo;
            this.listRepresent = listRepresent;
        }

    public ArrayList<Animal> getListRepresent() {
        return listRepresent;
    }
}
