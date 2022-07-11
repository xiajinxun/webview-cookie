/*
 * @Author: 夏金洵
 * @Date: 2022-06-08 10:30:36
 * @LastEditTime: 2022-07-11 11:45:19
 * @LastEditors: 夏金洵
 * @Description:
 * 可以输入预定的版权声明、个性签名、空行等
 */
package com.youth.cordova.cookie;

import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;

import org.apache.cordova.*;


import org.json.JSONArray;
import org.json.JSONException;

import java.net.URL;
import java.util.Map;

/**
 * This class echoes a string called from JavaScript.
 */
public class Cookie extends CordovaPlugin {
    private CallbackContext callbackContext;

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if ("setCookie".equals(action)) {
            String url = args.getString(0);
            String cookie = args.getString(1);
            setCookie(url,cookie);
            return true;
        }
        return false;
    }

    private void setCookie(String url,String cookie){
        try {
            CookieManager cookieManager = CookieManager.getInstance();
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                cookieManager.removeSessionCookie();// 移除
            } else {
                cookieManager.removeSessionCookies(null);// 移除
            }
            cookieManager.setAcceptCookie(true);
            cookieManager.setCookie(url, cookie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
