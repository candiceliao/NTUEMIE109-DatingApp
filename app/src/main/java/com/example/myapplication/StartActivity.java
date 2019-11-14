package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.ui.login.LoginActivity;

public class StartActivity extends AppCompatActivity {

    private Button loginPageBtn;
    private Button signUpPageBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        loginPageBtn = findViewById(R.id.loginBtn);
        signUpPageBtn = findViewById(R.id.signUpBtn);

        loginPageBtn.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(StartActivity.this , LoginActivity.class);
            startActivity(intent);
        });

        signUpPageBtn.setOnClickListener(v -> {
            Intent signIntent = new Intent();
            signIntent.setClass(StartActivity.this, SignUpActivity.class);
            startActivity(signIntent);
        });
    }
}
