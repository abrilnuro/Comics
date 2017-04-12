package com.aimewexample.comics.events;

import com.aimewexample.comics.models.Characters;

import java.util.List;

/**
 * Created by aimew on 11/04/2017.
 */

public class SuccessGetCharacter {
    List<Characters> characterList;

    public SuccessGetCharacter(List<Characters> characterList) {
        this.characterList = characterList;
    }

    public List<Characters> getCharacterList() {
        return characterList;
    }

    public void setCharacterList(List<Characters> characterList) {
        this.characterList = characterList;
    }
}
