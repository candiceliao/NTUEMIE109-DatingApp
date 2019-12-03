package com.example.myapplication.pair;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;

import java.util.Objects;

/**
 * Created by janisharali on 20/01/17.
 */

public class PairMainFragment extends Fragment {

    private SwipePlaceHolderView mSwipeView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pair_main, container, false);
        mSwipeView = rootView.findViewById(R.id.swipeView);

        mSwipeView.getBuilder()
                .setDisplayViewCount(3)
                .setSwipeDecor(new SwipeDecor()
//                        .setPaddingTop(10)
                        .setRelativeScale(0.01f)

                        .setSwipeInMsgLayoutId(R.layout.pair_swipe_in_msg_view)
                        .setSwipeOutMsgLayoutId(R.layout.pair_swipe_out_msg_view));


        for (Profile profile : Objects.requireNonNull(Utils.loadProfiles(getContext()))) {
            mSwipeView.addView(new PairCard(getContext(), profile, mSwipeView));
        }

        rootView.findViewById(R.id.rejectBtn).setOnClickListener(v -> mSwipeView.doSwipe(false));

        rootView.findViewById(R.id.acceptBtn).setOnClickListener(v -> mSwipeView.doSwipe(true));

        return rootView;
    }
}