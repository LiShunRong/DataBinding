package com.example.admin.guang.fragment;

import com.example.admin.guang.CommunityBean;
import com.example.admin.guang.R;
import com.example.admin.guang.adapter.DuanZiRecycylerAdapter;
import com.example.admin.guang.annoation.ActivityFragmentAnnoation;
import com.example.admin.guang.base.BaseFragment;
import com.example.admin.guang.base.BaseRecycylerAdapter;
import com.example.admin.guang.databinding.FragmentDuanZiBinding;
import com.example.admin.guang.databinding.FragmentRiBaoBinding;

/**
 * Created by admin on 2017/3/14.
 */
@ActivityFragmentAnnoation(contentId = R.layout.fragment_base_qu)
public class DuanZiFragment extends BaseQuFragment {
    @Override
    protected BaseRecycylerAdapter<CommunityBean.DataBean.ListBean> initAdapter() {
        return new DuanZiRecycylerAdapter(a);
    }

}
