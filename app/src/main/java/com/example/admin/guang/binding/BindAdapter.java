package com.example.admin.guang.binding;

import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.VelocityTracker;
import android.widget.ImageView;
import android.widget.TableLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.example.admin.guang.R;
import com.example.admin.guang.fragment.utils.GiftUtils;

/**
 * Created by admin on 2017/3/14.
 */

public class BindAdapter {
    @BindingAdapter({"setup"})
    public static void setupWithPager(TabLayout tabLayout, ViewPager pager) {
        tabLayout.setupWithViewPager(pager);
    }

    @BindingAdapter({"android:src"})
    public static void loadImage(final ImageView iv, String url) {
        if(GiftUtils.isGif(url)){
            Glide.with(iv.getContext()).load(url).asBitmap().priority(Priority.IMMEDIATE).diskCacheStrategy(DiskCacheStrategy.SOURCE).placeholder(R.drawable.shape_mark).centerCrop().into(iv);
        }else {
            Glide.with(iv.getContext()).load(url).asBitmap().placeholder(R.drawable.shape_mark).centerCrop().into(iv);
        }


    }

}
