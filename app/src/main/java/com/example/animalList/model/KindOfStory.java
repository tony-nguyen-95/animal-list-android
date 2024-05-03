package com.example.animalList.model;

import android.graphics.drawable.Drawable;
import java.io.Serializable;
import java.util.ArrayList;

public class KindOfStory implements Serializable {
    private String name;
    private Drawable photo;
    private ArrayList<Story> listStory;

    public KindOfStory(String name,
                       Drawable photo,
                       ArrayList<Story> listStory) {
        this.name = name;
        this.photo = photo;
        this.listStory = listStory;
    }

    public String getName() {
        return name;
    }

    public Drawable getPhoto() {
        return photo;
    }

    public ArrayList<Story> getListStory() {
        return listStory;
    }
}
