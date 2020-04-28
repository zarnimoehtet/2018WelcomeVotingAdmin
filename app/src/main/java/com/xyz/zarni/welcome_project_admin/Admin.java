package com.xyz.zarni.welcome_project_admin;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

import me.myatminsoe.mdetect.MDetect;

/**
 * Created by Zarni on 1/4/2018.
 */

public class Admin extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MDetect.INSTANCE.init(this);
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
