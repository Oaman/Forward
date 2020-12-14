package com.oman.pluginapk;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;

import java.lang.reflect.Method;

public class LoadUtils {

    private final static String apkPath = "/sdcard/pluginapk-debug.apk";

    private static Resources resources;

    public static Resources getResources(Context context) {
        if (resources == null) {
            resources = loadResources(context);
        }
        return resources;
    }

    /**
     * 加载资源 通过反射使用AssetManager的addAssetPath方法
     * public int addAssetPath(String path) {
     *
     * @param context
     */
    static Resources loadResources(Context context) {
        try {
            Method addAssetPathMethod = AssetManager.class.getMethod("addAssetPath", String.class);
            AssetManager assetManager =  AssetManager.class.newInstance();
            addAssetPathMethod.invoke(assetManager, apkPath);

            Resources resources = context.getResources();
            return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
