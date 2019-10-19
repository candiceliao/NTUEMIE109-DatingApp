package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
//import android.support.v7.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        new Handler().postDelayed(() -> {
            startActivity(new Intent(WelcomeActivity.this, StartActivity.class));
            finish();
        }, 2000);

    }
}

