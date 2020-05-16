package com.oman.forward.study.annotation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.oman.forward.R;

import java.util.ArrayList;

//import butterknife.BindView;
//import butterknife.ButterKnife;


/**
 * @author:ZhouJiang
 * @date:2020/5/17 00:11
 * @email:zhoujiang2012@163.com
 */
public class AActivity extends AppCompatActivity {
    //TODO please use command "adb shell am start -n com.oman.forward/.study.annotation.AActivity" to launch this activity

    @InjectView(R.id.title)
    private Button mTitle;

    @InjectView(R.id.title2)
//    @BindView(R.id.title2)
    public Button mTitle2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        InjectUtils.injectView(this);
//        ButterKnife.bind(this);
        mTitle.setText("self bind successfully");
        mTitle2.setText("Buffer Knife Bind successfully");

        ArrayList<UserParcelable> list = new ArrayList<>();
        list.add(new UserParcelable("test"));
        startActivity(new Intent(this, BActivity.class)
                .putExtra("name", "oman")
                .putExtra("attr", "handsome")
                .putExtra("array", new int[]{1, 2, 3})
                .putExtra("userParcelable", new UserParcelable("oman"))
                .putExtra("userParcelables", new UserParcelable[]{new UserParcelable("oman1")})
                .putExtra("users", new UserSerializable[]{new UserSerializable("oman2")})
                .putParcelableArrayListExtra("userParcelableList", list)
        );
    }
}


