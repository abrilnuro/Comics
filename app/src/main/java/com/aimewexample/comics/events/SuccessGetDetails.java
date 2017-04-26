package com.aimewexample.comics.events;

import com.aimewexample.comics.models.Characters;

/**
 * Created by caffeineLabs on 25/04/17.
 */

public class SuccessGetDetails {

    Characters character;

    public SuccessGetDetails(Characters character) {
        this.character = character;
    }

    public Characters getCharacter() {
        return character;
    }

    public void setCharacter(Characters character) {
        this.character = character;
    }
}
