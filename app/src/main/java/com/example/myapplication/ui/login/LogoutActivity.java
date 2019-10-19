package com.example.myapplication.ui.login;

//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class LogoutActivity extends AppCompatActivity {

    Button btn_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);

        btn_logout = findViewById(R.id.btn_logout);
        btn_logout.setOnClickListener(v -> finish());
    }

}



