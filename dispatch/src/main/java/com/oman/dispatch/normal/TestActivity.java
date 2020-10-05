package com.oman.dispatch.normal;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.oman.dispatch.R;

import static com.oman.dispatch.normal.Utils.getAction;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        View rootView = findViewById(R.id.rootView);
        final Button button = findViewById(R.id.buttonView);
        final ImageView imageView = findViewById(R.id.imageView);

        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("normally", "father onclick");
            }
        });

        rootView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i("normally", "father onTouch" + getAction(event.getAction()));
                return false;
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("normally", "button onClick");
            }
        });

        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.e("normally", "button onTouch: " + getAction(event.getAction()) + "--clickable:" + button.isClickable());

                return true;
            }
        });

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.e("normally", "image onTouch: " + getAction(event.getAction()) + "--clickable:" + imageView.isClickable());
                return true;
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("normally", "image onClick");
            }
        });

    }
}
