package com.example.myapplication.pair.hsiang.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;
import com.example.myapplication.pair.hsiang.viewModel.HsiangViewModel;

public class HsiangFragment extends Fragment {

    private HsiangViewModel hsiangViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        hsiangViewModel = ViewModelProviders.of(this).get(HsiangViewModel.class);

        View root = inflater.inflate(R.layout.fragment_hsiang, container, false);

        return root;


    }
}
