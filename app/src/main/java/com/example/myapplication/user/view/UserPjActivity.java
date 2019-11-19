package com.example.myapplication.user.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityUserPjBinding;
import com.example.myapplication.pair.PairMainActivity;
import com.example.myapplication.pair.hee.view.HeeActivity;
import com.example.myapplication.user.viewModel.UserPjViewModel;

public class UserPjActivity extends AppCompatActivity {

    private ActivityUserPjBinding activityUserPjBinding;
    private UserPjViewModel userPjViewModel = new UserPjViewModel();
    private ImageButton pairPageBtn;
    private ImageButton cardPageBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        activityUserPjBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_pj);

        userPjViewModel = ViewModelProviders.of(this).get(UserPjViewModel.class);

        activityUserPjBinding.setUserPjViewModel(userPjViewModel);

<<<<<<< HEAD
        //change to the pair page
        pairPageBtn = findViewById(R.id.friendButton);
        pairPageBtn.setOnClickListener(v -> {
            Intent pairIntent = new Intent();
            pairIntent.setClass(UserPjActivity.this , HeeActivity.class);
            startActivity(pairIntent);
        });

        //test the pair swipe
        cardPageBtn = findViewById(R.id.chatButton);
        cardPageBtn.setOnClickListener(v -> {
            Intent cardIntent = new Intent();
            cardIntent.setClass(UserPjActivity.this , PairMainActivity.class);
            startActivity(cardIntent);
        });


=======
>>>>>>> parent of 1636f70... Merge branch 'master' of https://github.com/candiceliao/NTUEMIE109-DatingApp
    }

}



