package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

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
    private String userName;
    private String userBirth;
    private String userId;
    private String userPwd;
    private String rePwd;

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

            editor1 = getSharedPreferences("data", MODE_PRIVATE).edit();
            editor1.putString("name", edUsername.getText().toString());
            editor1.putString("birthday", edUserBirth.getText().toString());
            editor1.putString("mail", edUserid.getText().toString());
            editor1.putString("password", edPasswd.getText().toString());
            editor1.putString("reEnterPwd", reEnterPwd.getText().toString());

            userName = edUsername.getText().toString();
            userBirth = edUserBirth.getText().toString();
            userId = edUserid.getText().toString();
            userPwd = edPasswd.getText().toString();
            rePwd = reEnterPwd.getText().toString();
            if (userName.trim().length() > 0 && userBirth.trim().length() > 0 &&
                    userId.trim().length() > 0 && userPwd.trim().length() > 0 &&
                    rePwd.trim().length() > 0) {

                userPwd = edPasswd.getText().toString();
                rePwd = reEnterPwd.getText().toString();
                if (edPasswd.equals(reEnterPwd)) {
                    editor1.commit();
                    interestIntent = new Intent();
                    interestIntent.setClass(SignUpActivity.this, MainActivity.class);
                    startActivity(interestIntent);
                } else {
                    // password doesn't match
                    Toast.makeText(getApplicationContext(),
                            "Password is incorrect",
                            Toast.LENGTH_LONG).show();
                }
            } else {
                // user didn't enter username or password
                Toast.makeText(this,
                        "Please enter empty fields",
                        Toast.LENGTH_LONG).show();
            }

            finish();

        });
    }
}
