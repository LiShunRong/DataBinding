package com.example.admin.guang.fragment;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.admin.guang.CommunityBean;
import com.example.admin.guang.R;
import com.example.admin.guang.VideoActivity;
import com.example.admin.guang.adapter.ShiPinRecycylerAdapter;
import com.example.admin.guang.annoation.ActivityFragmentAnnoation;
import com.example.admin.guang.base.BaseFragment;
import com.example.admin.guang.base.BaseRecycylerAdapter;
import com.example.admin.guang.databinding.FragmentRiBaoBinding;
import com.example.admin.guang.databinding.FragmentShiPinBinding;

/**
 * Created by admin on 2017/3/14.
 */
@ActivityFragmentAnnoation(contentId = R.layout.fragment_base_qu)
public class ShiPinFragment extends BaseQuFragment {
    @Override
    protected BaseRecycylerAdapter<CommunityBean.DataBean.ListBean> initAdapter() {
        return new ShiPinRecycylerAdapter(a);
    }

    @Override
    protected void onItemClick(CommunityBean.DataBean.ListBean bean) {
        Intent intent = new Intent(a, VideoActivity.class);
        intent.putExtra("videoUrl", bean.getVedio_url());
        startActivity(intent);
    }
}
