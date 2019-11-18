package com.example.myapplication.pair.hee.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityPairPageHeeBinding;
import com.example.myapplication.pair.hee.viewModel.HeeViewModel;

public class HeeActivity extends AppCompatActivity {

    private ActivityPairPageHeeBinding activityPairPageHeeBinding;
    private HeeViewModel heeViewModel = new HeeViewModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        activityPairPageHeeBinding = DataBindingUtil.setContentView(this, R.layout.activity_pair_page_hee);

        heeViewModel = ViewModelProviders.of(this).get(HeeViewModel.class);

        activityPairPageHeeBinding.setHeeViewModel(heeViewModel);


    }

}



