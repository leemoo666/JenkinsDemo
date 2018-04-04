package com.example.longpic;

import java.io.Serializable;

/**
 * Created by lixiaoming on 2018/3/23.
 */

public class EventScroll implements Serializable{
    private boolean isUp;

    public EventScroll(boolean isUp) {
        this.isUp = isUp;
    }

    public boolean isUp() {
        return isUp;
    }

    public void setUp(boolean up) {
        isUp = up;
    }
}
