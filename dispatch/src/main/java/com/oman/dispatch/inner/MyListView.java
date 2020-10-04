package com.oman.dispatch.inner;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ListView;

public class MyListView extends ListView {
    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private int mLastX, mLastY;

    /**
     * 处理之间冲突 - 内部拦截法
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.w("MainActivity", "MyListView dispatchTouchEvent action:" + ev.getAction());
        int x = (int) ev.getX();
        int y = (int) ev.getY();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.w("MainActivity", "MyListView requestDisallowInterceptTouchEvent true action:" + ev.getAction());
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                int deltaX = x - mLastX;
                int deltaY = y - mLastY;
                if (Math.abs(deltaX) > Math.abs(deltaY)) {
                    Log.w("MainActivity", "MyListView requestDisallowInterceptTouchEvent false action:" + ev.getAction());
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                break;
            default:
                break;
        }
        mLastX = x;
        mLastY = y;
        return super.dispatchTouchEvent(ev);
    }
}
