package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.example.myapplication.interest.InterestActivity;
import java.util.HashSet;
import android.app.Activity;
import android.content.SharedPreferences;
import android.widget.EditText;

public class SignUpActivity extends AppCompatActivity {

    @Override
    public void onCreate (Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_sign_up);
        SharedPreferences spref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = spref.edit();
        EditText edUserid = (EditText) findViewById(R.id.userid);
        SharedPreferences setting =
                getSharedPreferences("atm", MODE_PRIVATE);
        edUserid.setText(setting.getString("PREF_USERID", ""));

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
