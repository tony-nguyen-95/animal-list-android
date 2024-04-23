package com.example.animalList.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

public class Animal implements Serializable {
    private int mId;
    private String mName;
    private String mDescriptionPath; // File path for the description
    private String mPhoneNumber;
    private String mImagePath; // File path for the image
    private String mIconImagePath; // File path for the icon image
    private boolean isLiked = false;

    public Animal(int id, String name, String descriptionPath, String imagePath, String iconImagePath) {
        mId = id;
        mName = name;
        mDescriptionPath = descriptionPath;
        mImagePath = imagePath;
        mIconImagePath = iconImagePath;
    }

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getDescriptionPath() {
        return mDescriptionPath;
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

    public void loadImageFromAssets(Context context, ImageView imageView, String imagePath) {
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

    public void loadDescriptionFromAssets(Context context, TextView textView, String descriptionPath) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            // Open the input stream
            InputStream inputStream = context.getAssets().open(descriptionPath);

            // Read from the input stream
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                stringBuilder.append(new String(buffer, 0, length));
            }

            // Close the input stream
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Set the loaded description to the TextView
        textView.setText(stringBuilder.toString());
    }

}
