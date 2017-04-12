package com.aimewexample.comics.utils;

import android.app.Application;

import com.squareup.otto.Bus;

/**
 * Created by aimew on 11/04/2017.
 */

public class App extends Application {

    private static Bus bus;

    @Override
    public void onCreate(){
        super.onCreate();
        bus = new Bus();

    }

    public static Bus getBus() {
        return bus;
    }

}
