package com.oman.hook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void hookActivityInstrumentation(View view) {
        HookUtils.hookActivityInstrument(this);
        startActivity(new Intent(this, RegisterActivity.class));
    }

    public void hookActivityThreadInstrumentation(View view) {
        HookUtils.hookActivityThreadInstrument();
        getApplicationContext().startActivity(new Intent(this, RegisterActivity.class));
    }

    public void hookAMS(View view) {
        HookUtils.hookAMS();
        startActivity(new Intent(this, RegisterActivity.class));
    }

    public void hookNoRegisterActivity(View view) {
        HookUtils.hookAMSNoRegister();
        HookUtils.hookH();
        startActivity(new Intent(this, NoRegisterActivity.class));
    }
}
