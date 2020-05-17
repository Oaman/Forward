package com.oman.forward.study.annotation;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/**
 * @author:ZhouJiang
 * @date:2020/5/17 08:59
 * @email:zhoujiang2012@163.com
 */
public class BActivity extends AppCompatActivity {

    @InjectParams
    private String name;

    @InjectParams
    private String attr;

    @InjectParams
    private int[] array;

    @InjectParams
    private UserParcelable userParcelable;

    @InjectParams
    private UserParcelable[] userParcelables;

    @InjectParams("users")
    private UserSerializable[] userSerializables;

    @InjectParams
    private List<UserParcelable> userParcelableList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InjectUtils.injectParams(this);
        Field field = null;
        try {
            field = getClass().getDeclaredField("userParcelables");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        Log.i("aaa", "userParcelables.getType();: "+field.getType().isArray());
        Log.i("aaa", "userParcelables.getType()2: "+field.getType().getComponentType());

        Log.i("aaa", "name: " + name + "--attr:" + attr + "--array:" + Arrays.toString(array)
                + "--userParcelable:" + userParcelable.toString()
                + "--userParcelables:" + userParcelables[0]
                + "--userSerializables:" + userSerializables[0].toString()
                + "--userParcelableList:" + userParcelableList.toString());
    }
}
