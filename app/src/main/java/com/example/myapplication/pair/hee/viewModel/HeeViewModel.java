package com.example.myapplication.pair.hee.viewModel;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.pair.hee.model.HeeInfo;

import java.lang.reflect.Field;

public class HeeViewModel extends ViewModel {

    public final ObservableField<Field> userData = new ObservableField<>();

    private HeeInfo heeInfo = new HeeInfo();

    public void getHeeInfo() {

    }
}
