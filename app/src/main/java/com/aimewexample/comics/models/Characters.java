package com.aimewexample.comics.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by aimew on 10/04/2017.
 */

public class Characters implements Serializable {
    @SerializedName("name")
    String name;

    public Characters() {
        this.name = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
