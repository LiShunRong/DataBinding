package com.example.admin.guang.fragment.utils;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
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
import com.example.admin.guang.R;

/**
 * Created by admin on 2017/3/17.
 */

public class GiftUtils {
    Handler handler=new Handler(Looper.getMainLooper());
    public static boolean isGif(String url){
        if (url==null)return false;
        return url.contains(".gif");
    }
    public static int getGiftDuration(GlideDrawable drawable){
        if(!(drawable instanceof GifDrawable))return 0;
        final GifDrawable gifDrawable= (GifDrawable) drawable;
        // 获得帧数
        int frameCount = gifDrawable.getFrameCount();
        int duration=0;
        // 每一帧的时间
        for (int i = 0; i < frameCount; i++) {
            duration+=gifDrawable.getDecoder().getDelay(i);
        }
        return duration;
    }
    public  void loadGift(final ImageView giftView, final String url, final ImageView showIv){
        giftView.setVisibility(View.GONE);
        Glide.with(giftView.getContext()).load(url).asBitmap().priority(Priority.IMMEDIATE).diskCacheStrategy(DiskCacheStrategy.SOURCE).placeholder(R.drawable.shape_mark).centerCrop().into(showIv);
    }
}
