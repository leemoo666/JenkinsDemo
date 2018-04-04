package com.example.longpic.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

/**
 * Created by lixiaoming on 2018/3/21.
 */

@SuppressLint("AppCompatCustomView")
public class MoveView extends ImageView {

    private int scrollY = 0;

    private Canvas tmpCanvas;

    public MoveView(Context context) {
        super(context);
    }

    public MoveView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MoveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = getMeasuredWidth();
        int height = getMeasuredHeight();

        Bitmap bitmap = Bitmap.createBitmap(width, height + 200, Bitmap.Config.ARGB_8888);
        tmpCanvas = new Canvas(bitmap);

        Log.i("lxm", "width = " + width + "....height = " + height);
    }

    public void setBitMap(Bitmap bitMap) {
        new Canvas(bitMap);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        canvas.translate(0, scrollY);

        super.onDraw(canvas);
        Log.i("lxm", "onDraw = " + scrollY);
    }

    @Override
    public void setScrollY(int scrollY) {
        this.scrollY = scrollY;
        invalidate();
    }
}
