package com.example.myapplication.ui.login;

import android.content.SharedPreferences;
import android.widget.Toast;

import org.junit.Test;

import static android.content.Context.MODE_PRIVATE;
import static org.junit.Assert.*;

public class LoginActivityTest {

    @Test
    public void onActivityResult() {
        if (userId.trim().length() > 0 && userPwd.trim().length() > 0) {
            //有輸入
            String uName = null;
            String uPassword = null;

            if (userId.equals("pjchennn@gmail.com") && userPwd.equals("12345678")) {
                //登入成功
                SharedPreferences setting =
                        getSharedPreferences("userPjInfo", MODE_PRIVATE);
                setting.edit()
                        .putString("PREF_Pj_ID", userId)
                        .apply();

                Toast.makeText(this, "登入成功", Toast.LENGTH_LONG).show();
            } else {
                // username / password doesn't match
                Toast.makeText(getApplicationContext(),
                        "Username/Password is incorrect",
                        Toast.LENGTH_LONG).show();
            }
        } else {
            // user didn't enter username or password
            Toast.makeText(getApplicationContext(),
                    "Please enter username and password",
                    Toast.LENGTH_LONG).show();
        }
    }

    @Test
    public void onCreate() {
    }
}