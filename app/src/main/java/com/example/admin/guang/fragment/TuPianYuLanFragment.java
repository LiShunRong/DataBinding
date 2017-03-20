package com.example.admin.guang.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.example.admin.guang.R;
import com.example.admin.guang.annoation.ActivityFragmentAnnoation;
import com.example.admin.guang.base.BaseFragment;
import com.example.admin.guang.databinding.ItemTuPianYuLanBinding;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by admin on 2017/3/20.
 */
@ActivityFragmentAnnoation(contentId = R.layout.item_tu_pian_yu_lan)
public class TuPianYuLanFragment extends BaseFragment<ItemTuPianYuLanBinding> {
    boolean isFirst=true;
    private String src;
    private PhotoViewAttacher photoViewAttacher;

    @Override
    protected void initFragmentImpl() {
        bundle=getArguments();
        src = bundle.getString("src");
    }

    public  TuPianYuLanFragment newInstance(String src){
       Bundle bundle=new Bundle();
        bundle.putString("src",src);
        setArguments(bundle);
        return this;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
       if(binding!=null){
           performLazyLoad();
       }
    }

    private void performLazyLoad() {
        if(getUserVisibleHint()&&isFirst){
            isFirst=false;
            lazyLoad();
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        performLazyLoad();
    }


    private void lazyLoad() {
        photoViewAttacher = new PhotoViewAttacher(binding.pv);
        photoViewAttacher.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        binding.pb.setVisibility(View.VISIBLE);
        Glide.with(this).load(src).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(new SimpleTarget<GlideDrawable>() {
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
            binding.pv.setImageDrawable(resource);
                binding.pb.setVisibility(View.GONE);
                photoViewAttacher.update();
            }
        });
        boolean contains = src.contains("gif");
        if(contains){
            photoViewAttacher.setZoomable(false);
        }
    }
}
