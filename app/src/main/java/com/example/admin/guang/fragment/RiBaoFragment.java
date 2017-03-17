package com.example.admin.guang.fragment;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.admin.guang.CommunityBean;
import com.example.admin.guang.DetailsActivity;
import com.example.admin.guang.R;
import com.example.admin.guang.adapter.RiBaoRecyclerAdapter;
import com.example.admin.guang.annoation.ActivityFragmentAnnoation;
import com.example.admin.guang.base.BaseFragment;
import com.example.admin.guang.base.BaseRecycylerAdapter;
import com.example.admin.guang.databinding.FragmentRiBaoBinding;

/**
 * Created by admin on 2017/3/14.
 */
@ActivityFragmentAnnoation(contentId = R.layout.fragment_base_qu)
public class RiBaoFragment extends BaseQuFragment {
    @Override
    protected BaseRecycylerAdapter<CommunityBean.DataBean.ListBean> initAdapter() {

        return new RiBaoRecyclerAdapter(a);
    }

    @Override
    public void onItemClick(RecyclerView recyclerView, View view, int position) {
        CommunityBean.DataBean.ListBean itemAtPosition = adapter.getItemAtPosition(position);
        Intent intent=new Intent(a, DetailsActivity.class);
        Log.e("asda",itemAtPosition.getId()+"");
        intent.putExtra("id",itemAtPosition.getId());
        startActivity(intent);
    }
}
