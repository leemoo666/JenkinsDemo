package com.example.longpic.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by lixiaoming on 2018/3/23.
 */

public class MyFrameLayout extends FrameLayout {
    public MyFrameLayout(@NonNull Context context) {
        super(context);
    }

    public MyFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                Log.i("lxm", "action_move = " + getScrollY());
                break;
        }

        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
//                Log.i("lxm", " frameLayout dispatchTouchEvent action_down = " + getScrollY());
               break;
            case MotionEvent.ACTION_MOVE:
//                getParent().requestDisallowInterceptTouchEvent(false);
//                Log.i("lxm", " frameLayout dispatchTouchEvent action_move = " + getScrollY());
                break;
            case MotionEvent.ACTION_UP:
//                Log.i("lxm", " frameLayout dispatchTouchEvent action_up = " + getScrollY());
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("lxm", " frameLayout action_down = " + getScrollY());
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("lxm", " frameLayout action_move = " + getScrollY());
                break;
            case MotionEvent.ACTION_UP:
                Log.i("lxm", " frameLayout action_up = " + getScrollY());
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }
}
