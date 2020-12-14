package com.oman.pluginapk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("aaa", "启动插件的MainActivity");
//        setContentView(R.layout.activity_main);
        View view = LayoutInflater.from(context).inflate(R.layout.activity_main, null);
        setContentView(view);
        view.findViewById(R.id.goSecond).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.oman.pluginapk",
                        "com.oman.pluginapk.SecondActivity"));
                startActivity(intent);
            }
        });

        final ImageView imageView  = view.findViewById(R.id.imageView);
        int identifier = context.getResources().getIdentifier("ic_home", "drawable", "com.oman.pluginapk");
        final Drawable drawable = context.getResources().getDrawable(identifier);
        Log.i("aaa", "identifier:" + identifier);
        view.findViewById(R.id.showImage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageDrawable(drawable);
            }
        });
    }
}