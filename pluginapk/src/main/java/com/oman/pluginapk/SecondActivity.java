package com.oman.pluginapk;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("aaa", "启动插件的SecondActivity");
//        setContentView(R.layout.activity_second);
        View root = LayoutInflater.from(context).inflate(R.layout.activity_second, null);
        setContentView(root);
    }
}