package com.example.myapplication.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;
import com.example.myapplication.SignUpActivity;
import com.example.myapplication.user.view.UserPjActivity;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.login.LoginManager;

import static android.content.Context.MODE_PRIVATE;


/**
 * Called when the activity is first created.
 */
public class LoginActivity extends AppCompatActivity {

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
    FacebookSdk fbSDk;
    TextWatcher afterTextChangedListener;


    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
        Log.d("TAG", "requestCode = " + requestCode);
    }

    @Override
    final public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.d("TAG", "GO");

        //for facebook_login
        callbackManager = CallbackManager.Factory.create();

        fbSDk.setIsDebugEnabled(true);
        fbSDk.addLoggingBehavior(LoggingBehavior.INCLUDE_ACCESS_TOKENS);

        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<com.facebook.login.LoginResult>() {
            @Override
            public void onSuccess(com.facebook.login.LoginResult loginResult) {
                Log.d("TAG", "LoginResult = " + loginResult.toString());
            }

            @Override
            public void onCancel() {
                Log.d("TAG", "onCancel()");
            }

            @Override
            public void onError(FacebookException exception) {
                Log.d("TAG", exception.toString());
            }

        });

        //SharedPreferences
        spref = getPreferences(MODE_PRIVATE);
        editor = spref.edit();
        edUserid = findViewById(R.id.username);
        edPasswd = findViewById(R.id.password);
        loginBtn = findViewById(R.id.loginBtn);
        SignUpBtn = findViewById(R.id.signUpTextBtn);
        loadingProgressBar = findViewById(R.id.loading);
        userId = edUserid.getText().toString();
        userPwd = edPasswd.getText().toString();


        // Validate if username, password is filled
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

        loginViewModel = ViewModelProviders.of(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);


        loginViewModel.getLoginFormState().observe(this, loginFormState -> {
            if (loginFormState == null) {
                return;
            }
            loginBtn.setEnabled(loginFormState.isDataValid());
            if (loginFormState.getUsernameError() != null) {
                edUserid.setError(getString(loginFormState.getUsernameError()));
            }
            if (loginFormState.getPasswordError() != null) {
                edPasswd.setError(getString(loginFormState.getPasswordError()));
            }
        });

        loginViewModel.getLoginResult().observe(this, loginResult -> {
            if (loginResult == null) {
                return;
            }
            loadingProgressBar.setVisibility(View.GONE);
            if (loginResult.getError() != null) {
                showLoginFailed(loginResult.getError());
            }
            if (loginResult.getSuccess() != null) {
                updateUiWithUser(loginResult.getSuccess());
            }
            setResult(Activity.RESULT_OK);

            //Complete and destroy login activity once successful

        });

        afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                loginViewModel.loginDataChanged(edUserid.getText().toString(),
                        edPasswd.getText().toString());
            }
        };
        edUserid.addTextChangedListener(afterTextChangedListener);
        edPasswd.addTextChangedListener(afterTextChangedListener);
        edPasswd.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                loginViewModel.login(edUserid.getText().toString(),
                        edPasswd.getText().toString());
            }
            return false;
        });

        loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(v -> {
            Intent it = new Intent(LoginActivity.this, UserPjActivity.class);
            startActivity(it);
            loadingProgressBar.setVisibility(View.VISIBLE);
            loginViewModel.login(edUserid.getText().toString(),
                    edPasswd.getText().toString());
        });

        SignUpBtn.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(LoginActivity.this, SignUpActivity.class);
            startActivity(intent);
        });
    }


    private void updateUiWithUser(LoggedInUserView model) {
        String welcome = getString(R.string.welcome) + model.getDisplayName();
        // TODO : initiate successful logged in experience
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }

}
