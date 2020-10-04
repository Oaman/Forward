package com.oman.dispatch.outer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class MyViewPager extends ViewPager {
    public MyViewPager(@NonNull Context context) {
        super(context);
    }

    public MyViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 处理之间冲突 - 外部拦截法
     */

    private int mLastX, mLastY;

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int x = (int) ev.getX();
        int y = (int) ev.getY();

        if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            int deltaX = x - mLastX;
            int deltaY = y - mLastY;
            if (Math.abs(deltaX) > Math.abs(deltaY)) {
                return true;
            }
        }

        mLastX = x;
        mLastY = y;
        return super.onInterceptTouchEvent(ev);
    }
}
