package com.example.animalList.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

public class Animal implements Serializable {
    private int mId;
    private String mName;
    private String mDescription;
    private String mPhoneNumber;
    private String mImagePath; // File path for the image
    private String mIconImagePath; // File path for the icon image
    private boolean isLiked = false;

    public Animal(int id, String name, String description, String imagePath, String iconImagePath) {
        mId = id;
        mName = name;
        mDescription = description;
        mImagePath = imagePath;
        mIconImagePath = iconImagePath;
    }

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getImagePath() {
        return mImagePath;
    }

    public String getIconImagePath() {
        return mIconImagePath;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean status) {
        isLiked = status;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        mPhoneNumber = phoneNumber;
    }

    public void loadImageFromAssets(Context context,ImageView imageView, String imagePath) {
        try {
            // Open the input stream
            InputStream inputStream = context.getAssets().open(imagePath);

            // Decode the input stream into a Bitmap
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

            // Set the Bitmap to the ImageView
            imageView.setImageBitmap(bitmap);

            // Close the input stream
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
