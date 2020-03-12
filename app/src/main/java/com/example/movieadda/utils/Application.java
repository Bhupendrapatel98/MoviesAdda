package com.example.movieadda.utils;

import com.facebook.stetho.Stetho;

public class Application extends android.app.Application {

    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }

    }
