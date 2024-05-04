package com.example.animalList.model;

import java.io.Serializable;

public class Song implements Serializable {
    private String name, path, album;



    public Song(String name, String path, String album) {

        this.name = name;

        this.path = path;

        this.album = album;

    }



    public String getName() {

        return name;

    }



    public String getPath() {

        return path;

    }



    public String getAlbum() {

        return album;

    }
}
