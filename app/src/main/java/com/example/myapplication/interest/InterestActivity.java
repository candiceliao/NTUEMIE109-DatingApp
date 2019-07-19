package com.example.myapplication.interest;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityInterestBinding;

public class InterestActivity extends AppCompatActivity {

    private ActivityInterestBinding binding;

    private InterestViewModel interestViewModel = new InterestViewModel();

    @Override
    protected void onCreate(Bundle saveInstanceState) {

        super.onCreate(saveInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_interest);

        binding.setInterestViewModel(interestViewModel);

//        binding.btnRefresh.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                interestViewModel.refresh();
//            }
//        });
        // 在Xml中綁定了Button的OnClick，故此處不再設OnClickListener

    }
}
