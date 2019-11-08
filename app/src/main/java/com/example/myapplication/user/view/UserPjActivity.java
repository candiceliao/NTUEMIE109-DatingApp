package com.example.myapplication.user.view;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityUserPjBinding;
import com.example.myapplication.user.viewModel.UserPjViewModel;

public class UserPjActivity extends AppCompatActivity {

    private ActivityUserPjBinding activityUserPjBinding;
    private UserPjViewModel userPjViewModel = new UserPjViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        activityUserPjBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_pj);

        userPjViewModel = ViewModelProviders.of(this).get(UserPjViewModel.class);

        activityUserPjBinding.setUserPjViewModel(userPjViewModel);


    }

}



