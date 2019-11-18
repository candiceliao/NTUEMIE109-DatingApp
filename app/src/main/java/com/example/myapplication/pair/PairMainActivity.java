package com.example.myapplication.pair;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;

public class PairMainActivity extends AppCompatActivity {
    private SwipePlaceHolderView mSwipeView;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSwipeView = findViewById(R.id.swipeView);
        mContext = getApplicationContext();

        mSwipeView.getBuilder()
                .setDisplayViewCount(3)
                .setSwipeDecor(new SwipeDecor()
                        .setPaddingTop(20)
                        .setRelativeScale(0.01f)
                        .setSwipeInMsgLayoutId(R.layout.pair_swipe_in_msg_view)
                        .setSwipeOutMsgLayoutId(R.layout.pair_swipe_out_msg_view));


        for(Profile profile : Utils.loadProfiles(this.getApplicationContext())){
            mSwipeView.addView(new PairCard(mContext, profile, mSwipeView));
        }

        findViewById(R.id.rejectBtn).setOnClickListener(v -> mSwipeView.doSwipe(false));

        findViewById(R.id.acceptBtn).setOnClickListener(v -> mSwipeView.doSwipe(true));
    }
}
