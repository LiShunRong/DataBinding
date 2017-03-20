package com.example.admin.guang;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.example.admin.guang.adapter.TuPianYuLanPagerAdapter;
import com.example.admin.guang.annoation.ActivityFragmentAnnoation;
import com.example.admin.guang.base.BaseActivity;
import com.example.admin.guang.databinding.ActivityTuPianYuLanBinding;
import com.example.admin.guang.databinding.ItemTuPianYuLanBinding;
import com.example.admin.guang.fragment.TuPianFragment;
import com.example.admin.guang.fragment.TuPianYuLanFragment;

import java.util.ArrayList;
import java.util.List;

import uk.co.senab.photoview.PhotoViewAttacher;

@ActivityFragmentAnnoation(contentId = R.layout.activity_tu_pian_yu_lan)
public class TuPianYuLanActivity extends BaseActivity<ActivityTuPianYuLanBinding> {


    private String[] imgses;
    private String img;
    private List<Fragment> list;

    @Override
    protected void initActivityImpl() {
        PagerAdapter adapter = initAdapter();
        binding.setAdapter(adapter);
       binding.setPosition(getCurrentPosition());

    }

    private PagerAdapter initAdapter() {
        Intent intent = getIntent();
        imgses = intent.getStringArrayExtra("imgs");
        img = intent.getStringExtra("img");
        list = new ArrayList<>();
        PagerAdapter adapter=null;
        for (int i = 0; i < imgses.length; i++) {
            list.add(new TuPianYuLanFragment().newInstance(imgses[i]));
        }
        adapter=new TuPianYuLanPagerAdapter(list,getSupportFragmentManager());
        return adapter;
    }

    public Integer getCurrentPosition() {
        int position=0;
        for (int i = 0; i < imgses.length; i++) {
            if(img.equals(imgses[i])){
                position=i;
                break;
            }
        }
        return position;
    }
}
