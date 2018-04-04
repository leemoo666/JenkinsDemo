package com.example.longpic;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    private WebView wb_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wb_img = (WebView) findViewById(R.id.wb_img);
        wb_img.loadUrl("http://b-ssl.duitang.com/uploads/item/201402/24/20140224212510_eQRG5.jpeg");
        WebSettings settings = wb_img.getSettings();
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setBuiltInZoomControls(false); //选择内置缩放机制与单独缩放控件；
        settings.setDisplayZoomControls(false); //是否显示缩放控件
        settings.setSupportZoom(false);  //是否支持缩放
//        wb_img.setInitialScale(145); //第一次显示的缩放比例，例子是120%;
        //注释掉 wb_img.setInitialScale(145); 使用下面代码，则自适应屏幕居中显示
        //----------------------------------------
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        // ---------------------------------------------
        wb_img.getSettings().setJavaScriptEnabled(true);//启用js
        wb_img.getSettings().setBlockNetworkImage(false);//解决图片不显示
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
    }
}
