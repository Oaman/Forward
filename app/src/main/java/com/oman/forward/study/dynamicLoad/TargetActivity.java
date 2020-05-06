package com.oman.forward.study.dynamicLoad;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author:ZhouJiang
 * @date:2020/5/6 23:19
 * @email:zhoujiang2012@163.com
 *
 * 代表已经加载进来的插件Activity
 */
public class TargetActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("aaa", "target Activity onCreate ");

    }
}
