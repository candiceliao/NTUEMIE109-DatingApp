package com.example.myapplication.user.viewModel;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.user.model.UserPjInfo;

import java.lang.reflect.Field;

public class UserPjViewModel extends ViewModel {

    public final ObservableField<Field> userData = new ObservableField<>();

    private UserPjInfo userPjInfo = new UserPjInfo();

    public void getPjInfo() {

    }
}
