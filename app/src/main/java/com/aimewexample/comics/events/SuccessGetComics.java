package com.aimewexample.comics.events;

import com.aimewexample.comics.models.Comics;

import java.util.List;

/**
 * Created by aimew on 11/04/2017.
 */

public class SuccessGetComics {
    List<Comics> comicsList;

    public SuccessGetComics(List<Comics> comicsList) {
        this.comicsList = comicsList;
    }

    public List<Comics> getComicsList() {
        return comicsList;
    }

    public void setComicsList(List<Comics> comicsList) {
        this.comicsList = comicsList;
    }
}
