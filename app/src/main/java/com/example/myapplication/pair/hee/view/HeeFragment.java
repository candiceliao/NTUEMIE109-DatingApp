package com.example.myapplication.pair.hee.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;
import com.example.myapplication.pair.hee.viewModel.HeeViewModel;

public class HeeFragment extends Fragment {

    private HeeViewModel heeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        heeViewModel = ViewModelProviders.of(this).get(HeeViewModel.class);

        View root = inflater.inflate(R.layout.fragment_hee, container, false);

        return root;


    }

}



