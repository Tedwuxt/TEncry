package com.wuxtao.encry;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;

/**
 * @author TAO
 * @desc
 * @since 2020/9/15
 */
public class EncryBitmap {

    /**
     * base64 to bitmap
     *
     * @param base64
     * @return
     */
    public Bitmap base64ToBitmap(String base64) {
        if (null != base64 && !TextUtils.isEmpty(base64)) {
            try {
                byte[] bitmapArray = Base64.decode(base64.split(",")[1], Base64.DEFAULT);
                return BitmapFactory.decodeByteArray(bitmapArray, 0, bitmapArray.length);
            } catch (Exception e) {
                byte[] bitmapArray = Base64.decode(base64, Base64.DEFAULT);
                return BitmapFactory.decodeByteArray(bitmapArray, 0, bitmapArray.length);
            }
        }
        return null;
    }


    /**
     * bitmap to drawable
     *
     * @param bitmap
     * @return
     */
    public Drawable bitmapToDrawable(Bitmap bitmap) {
        Drawable drawable = new BitmapDrawable(bitmap);
        return drawable;
    }
}
