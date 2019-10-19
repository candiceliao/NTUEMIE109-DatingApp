package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.myapplication.interest.InterestActivity;

import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    //private Button readButton;
    private Button interestPageBtn;
    private EditText edUsername;
    private EditText edUserBirth;
    private EditText edUserid;
    private EditText edPasswd;
    private EditText reEnterPwd;

    private SharedPreferences spref;
    private SharedPreferences.Editor editor;
    private SharedPreferences.Editor editor1;

    private Intent interestIntent;

    @Override
    final public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_sign_up);

        spref = getPreferences(MODE_PRIVATE);
        editor = spref.edit();

        edUsername = findViewById(R.id.nameEditText);
        edUserBirth = findViewById(R.id.birthdayEditText);
        edUserid = findViewById(R.id.mailEditText);
        edPasswd = findViewById(R.id.pwdEditText);
        reEnterPwd = findViewById(R.id.reEnterPwdEditText);

        interestPageBtn = findViewById(R.id.nextBtn);
        SharedPreferences setting =
                getSharedPreferences("atm", MODE_PRIVATE);

        edUserid.setText(setting.getString("PREF_USERID", ""));



        interestPageBtn.setOnClickListener(v -> {
            interestIntent = new Intent();
            interestIntent.setClass(SignUpActivity.this, InterestActivity.class);
            startActivity(interestIntent);

            editor1 = getSharedPreferences("data", MODE_PRIVATE).edit();
            editor1.putString("name", edUsername.getText().toString());
            editor1.putString("birthday", edUserBirth.getText().toString());
            editor1.putString("mail", edUserid.getText().toString());
            editor1.putString("password", edPasswd.getText().toString());
            editor1.putString("reEnterPwd", reEnterPwd.getText().toString());

            if (edPasswd.equals(reEnterPwd) ) {
                editor1.commit();
            } else {
                // password doesn't match
                Toast.makeText(getApplicationContext(),
                        "Password is incorrect",
                        Toast.LENGTH_LONG).show();
            }

        finish();

        });
    }
}
