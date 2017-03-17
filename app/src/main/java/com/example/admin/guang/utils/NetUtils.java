package com.example.admin.guang.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telecom.ConnectionService;

/**
 * Created by admin on 2017/3/15.
 */

public class NetUtils {
    public static boolean isConnected(Context c) {
        ConnectivityManager systemService = (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
        try {
            NetworkInfo activeNetworkInfo = systemService.getActiveNetworkInfo();
            boolean connected = activeNetworkInfo.isConnected();
            return connected;
        } catch (Exception e) {
            return false;
        }

    }
}
