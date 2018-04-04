package com.example.longpic.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;

/**
 * Created by lixiaoming on 2018/3/23.
 */

public class SlideUpPanelView extends SlidingUpPanelLayout {

    public SlideUpPanelView(Context context) {
        super(context);
    }

    public SlideUpPanelView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
//                Log.i("lxm", "SlideUpPanelView down");
                break;
            case MotionEvent.ACTION_MOVE:
//                Log.i("lxm", "SlideUpPanelView MOVE");
                break;
            case MotionEvent.ACTION_UP:
//                Log.i("lxm", "SlideUpPanelView UP");
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }
}
