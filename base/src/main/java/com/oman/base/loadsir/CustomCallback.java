package com.oman.base.loadsir;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.kingja.loadsir.callback.Callback;
import com.oman.base.R;

/**
 * Description:TODO
 * Create Time:2017/9/3 10:22
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class CustomCallback extends Callback {

    @Override
    protected int onCreateView() {
        return R.layout.layout_custom;
    }

    @Override
    protected boolean onReloadEvent(final Context context, View view) {
        Toast.makeText(context.getApplicationContext(), "Hello buddy, how r u! :p", Toast.LENGTH_SHORT).show();
        (view.findViewById(R.id.iv_gift)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context.getApplicationContext(), "It's your gift! :p", Toast.LENGTH_SHORT).show();
            }
        });
        return true;
    }
}
