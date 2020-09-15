package com.wuxtao.tencry;

import android.app.Application;
import android.util.Log;

import com.wuxtao.encry.EncryLib;

/**
 * @author TAO
 * @desc
 * @since 2020/9/15
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        EncryLib.getInstance().init(this, "caX1Ix9kaXNuYpWp", "hmnHV2silbr21x9O");

        String result = EncryLib.getInstance().aseDecrypt("RHvfiWVUIR+Lx1sIKCv8vQ==");
        Log.e("result", result);
    }
}
