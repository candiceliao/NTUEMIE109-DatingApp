package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.ui.login.LoginActivity;

public class StartActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button loginPageBtn = findViewById(R.id.loginBtn);
        Button signUpPageBtn = findViewById(R.id.signUpBtn);

        loginPageBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(StartActivity.this , LoginActivity.class);
                startActivity(intent);
            }
        });

        signUpPageBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent signIntent = new Intent();
                signIntent.setClass(StartActivity.this, SignUpActivity.class);
                startActivity(signIntent);
            }
        });
    }
}
