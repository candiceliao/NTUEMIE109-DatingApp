package com.example.myapplication.data.model;

import android.os.Handler;

public class InterestModel {

    public void retrieveData(final onDataReadyCallback callback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                callback.onDataReady("New InterestModel");
            }

        }, 1500);
    }

    public interface onDataReadyCallback {
         void onDataReady(String data);
    }

}
