package com.example.admin.guang.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.admin.guang.fragment.BaseQuFragment;
import com.example.admin.guang.fragment.DuanZiFragment;
import com.example.admin.guang.fragment.RiBaoFragment;
import com.example.admin.guang.fragment.ShiPinFragment;
import com.example.admin.guang.fragment.TuPianFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */

public class QuFragmnetAdapter extends FragmentPagerAdapter {
    List<Fragment> list;
    List<String> titles;

    public QuFragmnetAdapter(FragmentManager fm) {
        super(fm);
        init();
    }

    private void init() {
        list = new ArrayList<>();
        list.add(new RiBaoFragment().newInstance("daily"));
        list.add(new DuanZiFragment().newInstance("1"));
        list.add(new TuPianFragment().newInstance("2"));
        list.add(new ShiPinFragment().newInstance("3"));
        titles = new ArrayList<>();
        titles.add("日报");
        titles.add("段子");
        titles.add("图片");
        titles.add("视频");
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
