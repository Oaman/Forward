package com.oman.dispatch.normal;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.appcompat.widget.AppCompatImageView;

import static com.oman.dispatch.normal.Utils.getAction;

public class MyImageView extends AppCompatImageView {
    public MyImageView(Context context) {
        super(context);
    }

    public MyImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.i("normal", "MyImageView dispatchTouchEvent action:" + getAction(event.getAction()));
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i("normal", "MyImageView onTouchEvent action:" + getAction(event.getAction()));
        return super.onTouchEvent(event);
    }
}
