package com.oman.hook;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CopyUtils {

    /**
     * 将asset中的dex文件拷贝到外部目录
     *
     * @param context
     */
    public static void copy(Context context) {
        try (InputStream inputStream = context.getAssets().open("hack.dex");
             FileOutputStream outputStream = new FileOutputStream(new File(context.getExternalFilesDir(""), "hack.dex"))) {
            byte[] buffer = new byte[4096];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
