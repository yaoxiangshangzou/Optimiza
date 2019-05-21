package com.coroutine.bod.optimiza;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;

public class BigView extends View implements View.OnTouchListener, GestureDetector.OnGestureListener {

    BitmapFactory.Options mOptions = new BitmapFactory.Options();

    private Rect mRect = new Rect();
    int mImageWidth, mImageheight;
    private int measuredHeight;
    private int measuredWidth;
    private BitmapRegionDecoder mDecoder;
    private Bitmap bitmap;

    public BigView(Context context) {
        super(context);
    }

    public BigView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BigView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void setImage(InputStream inputStream) {
        mOptions.inJustDecodeBounds = true;
        mOptions.inMutable = true;
        BitmapFactory.decodeStream(inputStream, null, mOptions);

        //设置图片的格式
        mOptions.inPreferredConfig = Bitmap.Config.RGB_565;
        //解码器，指定需要加载的图片的区域
        try {
            mDecoder = BitmapRegionDecoder.newInstance(inputStream, false);
        } catch (IOException e) {
            e.printStackTrace();
        }


        requestLayout();
//        mOptions.inJustDecodeBounds 把长图进行缩放

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        measuredHeight = getMeasuredHeight();
        measuredWidth = getMeasuredWidth();

        mRect.left = 0;
        mRect.top = 0;
        mRect.bottom = measuredHeight;


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (mDecoder == null) return;

        bitmap = mDecoder.decodeRegion(mRect, mOptions);
        //把得到的矩阵的大小的内存进行缩放

        Matrix matrix = new Matrix();
//        matrix.setScale(); 这里设置缩放比

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onDown(MotionEvent e) {

        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}
