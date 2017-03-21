package com.example.admin.guang.fragment.utils;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.example.admin.guang.CommunityBean;
import com.example.admin.guang.R;

/**
 * Created by admin on 2017/3/17.
 */

public class GiftUtils {
    Handler handler = new Handler(Looper.getMainLooper());

    public static boolean isGif(String url, boolean isLoad) {
        if (url == null) return false;
        return url.contains(".gif") && !isLoad;
    }

    public static int getGiftDuration(GlideDrawable drawable) {
        if (!(drawable instanceof GifDrawable)) return 0;
        final GifDrawable gifDrawable = (GifDrawable) drawable;
        // 获得帧数
        int frameCount = gifDrawable.getFrameCount();
        int duration = 0;
        // 每一帧的时间
        for (int i = 0; i < frameCount; i++) {
            duration += gifDrawable.getDecoder().getDelay(i);
        }
        return duration;
    }

    public void loadGift(final ImageView giftView, final String url, final ImageView showIv, final ProgressBar pb, CommunityBean.DataBean.ListBean bean) {
        bean.setLoad(true);
        giftView.setVisibility(View.GONE);
        pb.setVisibility(View.VISIBLE);
        Glide.with(giftView.getContext()).load(url).priority(Priority.HIGH).listener(getRequestListener(giftView, pb,bean)).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).placeholder(showIv.getDrawable()).centerCrop().into(showIv);
    }

    @NonNull
    private RequestListener<String, GlideDrawable> getRequestListener(final ImageView giftView, final ProgressBar pb, final CommunityBean.DataBean.ListBean bean) {
        return new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                pb.setVisibility(View.GONE);
                giftView.setVisibility(View.INVISIBLE);
                bean.setLoad(false);
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                pb.setVisibility(View.GONE);
                bean.setLoad(false);
                return false;
            }
        };
    }
}
