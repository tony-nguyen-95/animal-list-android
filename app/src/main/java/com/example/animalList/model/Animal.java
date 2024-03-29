package com.example.animalList.model;


import java.io.Serializable;

public class Animal implements Serializable {
    private int mId;
    private String mName;
    private String mDescription;
    private int mImage;

    private int mIconImage;

    private boolean isLiked = false;

    public Animal(int id,String name,String description, int image,int iconImage) {
        mId = id;
        mName = name;
        mImage = image;
        mIconImage = iconImage;
        mDescription = description;
    }

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public int getImage() {
        return mImage;
    }

    public int getIconImage() {
        return mIconImage;
    }

    public boolean isLiked(){
        return  isLiked;
    }

    public  String getDescription(){
        return  mDescription;
    }

    public void setLiked(boolean status){
        this.isLiked = status;
    }
}
