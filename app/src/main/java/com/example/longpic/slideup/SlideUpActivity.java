package com.example.longpic.slideup;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import com.example.longpic.EventScroll;
import com.example.longpic.R;
import com.example.longpic.widget.SlideUpPanelView;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class SlideUpActivity extends AppCompatActivity {

    SlideUpPanelView sliding_layout;

    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_up);
        EventBus.getDefault().register(this);
        frameLayout = findViewById(R.id.flBoot);

        sliding_layout = findViewById(R.id.sliding_layout);

        sliding_layout.setScrollableView(frameLayout);
        sliding_layout.setAnchorPoint(0.6f);
        sliding_layout.setPanelState(SlidingUpPanelLayout.PanelState.ANCHORED);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        final BooterFragment fragment = new BooterFragment();
        transaction.replace(R.id.flBoot, fragment).commitAllowingStateLoss();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    //priority越大，级别越高
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(EventScroll event) {

        frameLayout.requestDisallowInterceptTouchEvent(!event.isUp());
        frameLayout.getChildAt(0);
    }
}
