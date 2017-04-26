package com.aimewexample.comics.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by aimew on 10/04/2017.
 */

public class Characters implements Serializable {
    @SerializedName("name")
    String name;
    String image;
    String description;


    public Characters(String name, String image, String description) {
        this.name = name;
        this.image = image;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
