package com.example.longpic.bean;

import java.io.Serializable;

/**
 * Created by lixiaoming on 2018/3/21.
 */

public class MoveItem implements Serializable{
    private String url;
    private String title;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
