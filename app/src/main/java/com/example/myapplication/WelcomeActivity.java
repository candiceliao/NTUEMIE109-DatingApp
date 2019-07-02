package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import com.example.myapplication.ui.login.LoginActivity;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
                finish();
            }
        }, 2000);

    }
}

