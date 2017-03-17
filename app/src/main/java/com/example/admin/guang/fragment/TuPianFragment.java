package com.example.admin.guang.fragment;

import com.example.admin.guang.CommunityBean;
import com.example.admin.guang.R;
import com.example.admin.guang.adapter.TuPianRecycylerAdapter;
import com.example.admin.guang.annoation.ActivityFragmentAnnoation;
import com.example.admin.guang.base.BaseFragment;
import com.example.admin.guang.base.BaseRecycylerAdapter;
import com.example.admin.guang.databinding.FragmentRiBaoBinding;
import com.example.admin.guang.databinding.FragmentTuPianBinding;

/**
 * Created by admin on 2017/3/14.
 */
@ActivityFragmentAnnoation(contentId = R.layout.fragment_base_qu)
public class TuPianFragment extends BaseQuFragment{
    @Override
    protected BaseRecycylerAdapter<CommunityBean.DataBean.ListBean> initAdapter() {
        return new TuPianRecycylerAdapter(a);
    }

}
