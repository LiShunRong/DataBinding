package com.example.admin.guang.utils;

import android.content.Context;
import android.util.Log;

import java.io.IOException;

import it.xabaras.android.logger.Logger;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by admin on 2017/3/15.
 */

public class NoNetCacheInterceptor implements Interceptor {
    Context ctx;

    public NoNetCacheInterceptor(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();

        if(!NetUtils.isConnected(ctx)){
            request=request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
        }
        Response proceed = chain.proceed(request);
        Log.e("tag1",(proceed.cacheResponse()!=null)+"----->缓存的response");
        Log.e("tag1",(proceed.networkResponse()!=null)+"----->网络的response");
        Log.e("tag1","========================");
        return proceed;
    }
}