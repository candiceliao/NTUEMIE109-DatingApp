package com.example.myapplication.user.viewModel;

import android.content.Intent;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.R;
import com.example.myapplication.pair.hee.view.HeeActivity;
import com.example.myapplication.user.model.UserPjInfo;
import com.example.myapplication.user.view.UserPjActivity;

import java.lang.reflect.Field;

import static androidx.databinding.library.baseAdapters.BR.HeeViewModel;

public class UserPjViewModel extends ViewModel {

    public final ObservableField<Field> userData = new ObservableField<>();

    private UserPjInfo userPjInfo = new UserPjInfo();

    public void getPjInfo() {

    }
}
