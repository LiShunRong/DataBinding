package com.example.admin.guang;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.example.admin.guang.annoation.ActivityFragmentAnnoation;
import com.example.admin.guang.base.BaseActivity;
import com.example.admin.guang.databinding.ActivityDetailsBinding;
import com.example.admin.guang.service.OnLoadDataFinishListener;
import com.example.admin.guang.utils.HttpUtils;

import java.util.concurrent.ExecutionException;

@ActivityFragmentAnnoation(contentId = R.layout.activity_details)
public class DetailsActivity extends BaseActivity<ActivityDetailsBinding> implements OnLoadDataFinishListener<DetailsBean>, SwipeRefreshLayout.OnRefreshListener {
     @Override
    protected void initActivityImpl() {
         binding.swip.setOnRefreshListener(this);
        loadData();
    }

    private void loadData() {
        binding.swip.setRefreshing(true);
        int id = getIntent().getIntExtra("id",0);
        Log.e("tag",id+"");
        HttpUtils.loadDeatilsData(id+"",this);
    }

    @Override
    public void loadSuccess(DetailsBean detailsBean, int page) {
        DetailsBean.InfoBean info = detailsBean.getData().getInfo();
        binding.setInfobean(info);
        binding.swip.setRefreshing(false);
        binding.swip.setEnabled(false);
        binding.wv.loadDataWithBaseURL(null,info.getContent(),"text/html",  "utf-8", "");

    }




    @Override
    public void loadError(String msg, int page) {
        Toast.makeText(this, ""+msg, Toast.LENGTH_SHORT).show();
        binding.swip.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        loadData();
    }



}
