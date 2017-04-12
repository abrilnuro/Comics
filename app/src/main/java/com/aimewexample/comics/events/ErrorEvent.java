package com.aimewexample.comics.events;

/**
 * Created by aimew on 11/04/2017.
 */

public class ErrorEvent {
    String message;

    public ErrorEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
