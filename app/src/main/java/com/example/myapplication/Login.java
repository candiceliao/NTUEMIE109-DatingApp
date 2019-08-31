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
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

public class Login<EditText> {

        public void login(View v, Object findViewById) {
        EditText edUserid = (EditText) findViewById(R.id.userid);
        EditText edPasswd = (EditText) findViewById(R.id.passwd);

            String uid = edUserid.getText().toString();
            String pw = edPasswd.getText().toString();
        if (uid.equals("jack") && pw.equals("1234")) { //登入成功
            SharedPreferences setting =
                    getSharedPreferences("atm", MODE_PRIVATE);
            setting.edit()
                    .putString("PREF_USERID", uid)
                    .commit();
            Toast.makeText(this, "登入成功", Toast.LENGTH_LONG).show();
        }
    }


}