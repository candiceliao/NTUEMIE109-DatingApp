package com.example.myapplication.ui.login;

import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.myapplication.R;
import com.facebook.CallbackManager;

import org.junit.Test;

import static android.content.Context.MODE_PRIVATE;
import static org.junit.Assert.*;

public class LoginActivityTest {
    private LoginViewModel loginViewModel;
    private Button loginBtn;
    private Button SignUpBtn;

    private EditText edUserid;
    private EditText edPasswd;
    private ProgressBar loadingProgressBar;
    private String userId;
    private String userPwd;

    CallbackManager callbackManager;
    SharedPreferences spref;
    SharedPreferences.Editor editor;

    @Test
    public void onActivityResult() {
        spref = getPreferences(MODE_PRIVATE);
        editor = spref.edit();
        edUserid = findViewById(R.id.username);
        edPasswd = findViewById(R.id.password);
        loginBtn = findViewById(R.id.loginBtn);
        SignUpBtn = findViewById(R.id.signUpTextBtn);
        loadingProgressBar = findViewById(R.id.loading);
        userId = edUserid.getText().toString();
        userPwd = edPasswd.getText().toString();
        if (userId.trim().length() > 0 && userPwd.trim().length() > 0) {
            //有輸入
            //String uName = null;
            //String uPassword = null;

            if (userId.equals("pjchennn@gmail.com") && userPwd.equals("12345678")) {
                //登入成功
                SharedPreferences setting =
                        getSharedPreferences("userPjInfo", MODE_PRIVATE);
                setting.edit()
                        .putString("PREF_Pj_ID", userId)
                        .putString("PREF_Pj_Pwd", userPwd)
                        .apply();

                Toast.makeText(this, "登入成功", Toast.LENGTH_LONG).show();
            } else {
                // username / password doesn't match
                Toast.makeText(this,
                        "Username/Password is incorrect",
                        Toast.LENGTH_LONG).show();
            }
        } else {
            // user didn't enter username or password
            Toast.makeText(this,
                    "Please enter username and password",
                    Toast.LENGTH_LONG).show();
        }
    }

    @Test
    public void onCreate() {
    }
}