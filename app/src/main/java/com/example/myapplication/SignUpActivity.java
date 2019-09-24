package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.interest.InterestActivity;

import android.content.SharedPreferences;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    //private Button readButton;
    private Button interestPageBtn;
    private EditText edUsername;
    private EditText edUserBirth;
    private EditText edUserid;
    private EditText edPasswd;
    private EditText reEnterPwd;
    String TAG = "AppCompatActivity";

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_sign_up);

        SharedPreferences spref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = spref.edit();

        final EditText edUsername = (EditText) findViewById(R.id.nameEditText);
        final EditText edUserBirth = (EditText) findViewById(R.id.birthdayEditText);
        final EditText edUserid = (EditText) findViewById(R.id.mailEditText);
        final EditText edPasswd = (EditText) findViewById(R.id.pwdEditText);
        final EditText reEnterPwd = (EditText) findViewById(R.id.reEnterPwdEditText);
        Button interestPageBtn = findViewById(R.id.nextBtn);
        SharedPreferences setting =
                getSharedPreferences("atm", MODE_PRIVATE);

        edUserid.setText(setting.getString("PREF_USERID", ""));



        interestPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent interestIntent = new Intent();
                interestIntent.setClass(SignUpActivity.this, InterestActivity.class);
                startActivity(interestIntent);

                SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                editor.putString("name", edUsername.getText().toString());
                editor.putString("birthday", edUserBirth.getText().toString());
                editor.putString("mail", edUserid.getText().toString());
                editor.putString("password", edPasswd.getText().toString());
                editor.putString("reEnterPwd", reEnterPwd.getText().toString());

                if (edPasswd.equals(reEnterPwd) ) {
                    editor.commit();
                } else {
                    // password doesn't match
                    Toast.makeText(getApplicationContext(),
                            "Password is incorrect",
                            Toast.LENGTH_LONG).show();
                }

            finish();

            }
        });
    }
}
