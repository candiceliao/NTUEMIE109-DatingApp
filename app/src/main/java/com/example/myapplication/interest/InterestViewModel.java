package com.example.myapplication.interest;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import com.example.myapplication.data.model.InterestModel;

public class InterestViewModel extends ViewModel {

    public final ObservableField<String> mData = new ObservableField<>();

    public final ObservableBoolean isLoading = new ObservableBoolean(false);

    private InterestModel interestmodel = new InterestModel();

    public void refresh() {

        isLoading.set(true);

        interestmodel.retrieveData(new InterestModel.onDataReadyCallback() {

            @Override
            public void onDataReady(String data) {

                mData.set(data);
                isLoading.set(false);
            }
        });
    }
}
