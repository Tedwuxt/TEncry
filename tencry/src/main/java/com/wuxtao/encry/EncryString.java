package com.wuxtao.encry;

import android.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author TAO
 * @desc
 * @since 2020/9/15
 */
public class EncryString {

    /**
     * AES/CBC/PKCS5Padding
     * UTF-8
     *
     * @param data
     * @return
     */
    public String aseDecrypt(String data) {
        try {
            String sKey = EncryLib.getInstance().getKey();
            String sIv = EncryLib.getInstance().getIv();
            byte[] byteMi = Base64.decode(data.getBytes(), Base64.NO_WRAP);
            IvParameterSpec zeroIv = new IvParameterSpec(sIv.getBytes());
            SecretKeySpec key = new SecretKeySpec(sKey.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key, zeroIv);
            byte[] decryptedData = cipher.doFinal(byteMi);
            return new String(decryptedData, "UTF-8");
        } catch (Exception e) {
            return data;
        }
    }

}
