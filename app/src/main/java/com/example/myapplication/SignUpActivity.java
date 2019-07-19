package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.interest.InterestActivity;

public class SignUpActivity extends AppCompatActivity {

    @Override
    public void onCreate (Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_sign_up);

        Button interestPageBtn = findViewById(R.id.nextBtn);

        interestPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent interestIntent = new Intent();
                interestIntent.setClass(SignUpActivity.this, InterestActivity.class);
                startActivity(interestIntent);
            }
        });
    }
}
