package com.wuxtao.encry;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;

/**
 * @author TAO
 * @desc
 * @since 2020/9/15
 */
public class EncryLib {
    private static final String TAG = "EncryLib";

    private boolean isInit = false;

    private Context mContext;
    private String mKey;
    private String mIv;

    private static volatile EncryLib singleton;

    private EncryLib() {
    }

    public static EncryLib getInstance() {
        if (singleton == null) {
            synchronized (EncryLib.class) {
                if (singleton == null) {
                    singleton = new EncryLib();
                }
            }
        }
        return singleton;
    }

    public void init(Context context, String key, String iv) {
        if (null == context) {
            throw new NullPointerException("context must be not null");
        }
        if (TextUtils.isEmpty(key)) {
            throw new NullPointerException("key must be not null");
        }
        if (TextUtils.isEmpty(iv)) {
            throw new NullPointerException("iv must be not null");
        }

        this.mContext = context;
        this.mKey = key;
        this.mIv = iv;

        this.isInit = true;
    }

    public static String getTAG() {
        return TAG;
    }

    public Context getContext() {
        return mContext;
    }

    public String getKey() {
        return mKey;
    }

    public String getIv() {
        return mIv;
    }

    /**
     *
     */
    public String aseDecrypt(String content) {
        EncryString encryString = new EncryString();
        return encryString.aseDecrypt(content);
    }

    public Bitmap base642bitmap(String base64) {
        EncryBitmap encryBitmap = new EncryBitmap();
        return encryBitmap.base64ToBitmap(base64);
    }

    public Drawable bitmap2drawable(Bitmap bitmap) {
        EncryBitmap encryBitmap = new EncryBitmap();
        return encryBitmap.bitmapToDrawable(bitmap);
    }
}
