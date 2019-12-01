package com.example.myapplication.user.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;
import com.example.myapplication.user.viewModel.UserPjViewModel;

public class UserPjFragment extends Fragment {

    private UserPjViewModel userPjViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        userPjViewModel = ViewModelProviders.of(this).get(UserPjViewModel.class);

        View root = inflater.inflate(R.layout.fragment_user_pj, container, false);
//        final ImageView imageView = root.findViewById(R.id.userImage);
//        userPjViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}

