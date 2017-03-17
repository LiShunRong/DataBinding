package com.example.admin.guang.utils;

import android.content.Context;
import android.util.Log;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by admin on 2017/3/15.
 */

public class NetCacheInterceptor implements Interceptor {
    Context ctx;

    public NetCacheInterceptor(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Log.e("inter","网络拦截器");
        Request request = chain.request();

        Response response = chain.proceed(request);
        if(request.method().equals("POST"))return response;

        if(response.isSuccessful())
        return response.newBuilder().header("Cache-Control", " public, max-age=60").removeHeader("Pragma").build();
return response;
    }
}
