package com.example.admin.guang.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.admin.guang.CommunityBean;
import com.example.admin.guang.R;
import com.example.admin.guang.annoation.ActivityFragmentAnnoation;
import com.example.admin.guang.base.BaseFragment;
import com.example.admin.guang.base.BaseRecycylerAdapter;
import com.example.admin.guang.base.SuperRecyclerView;
import com.example.admin.guang.databinding.FragmentBaseQuBinding;
import com.example.admin.guang.fragment.utils.AdapterManager;
import com.example.admin.guang.service.OnLoadDataFinishListener;
import com.example.admin.guang.utils.HttpUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */

public class BaseQuFragment extends BaseFragment<FragmentBaseQuBinding> implements SwipeRefreshLayout.OnRefreshListener, OnLoadDataFinishListener<List<CommunityBean.DataBean.ListBean>>, SuperRecyclerView.OnItemClickListener {
    String type;
    int page = 1;
    BaseRecycylerAdapter<CommunityBean.DataBean.ListBean> adapter;
    boolean enableLoadMore = true;
    LinearLayoutManager linearLayoutManager;
    boolean isLoadMore;
    boolean isFirst = true;

    @Override
    protected void initFragmentImpl() {
        type = bundle.getString("type");
        adapter = initAdapter();
        initView();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getUserVisibleHint() == true) {
            performLoadFirst();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && binding != null) {
            performLoadFirst();
        }
    }

    private void performLoadFirst() {
        if (isFirst) {
            isFirst = false;
            binding.swip.setRefreshing(true);
            loadFirst();
            Log.e("tagasd", getClass().getSimpleName() + "jizaishuju");
        }
    }

    protected BaseRecycylerAdapter<CommunityBean.DataBean.ListBean> initAdapter() {
        throw new IllegalStateException("必须重写initAdapter方法");
    }

    public BaseQuFragment newInstance(String type) {

        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        setArguments(bundle);
        return this;
    }

    private void initView() {
        binding.swip.setOnRefreshListener(this);
        linearLayoutManager = new LinearLayoutManager(a);
        binding.recycler.setLayoutManager(linearLayoutManager);
        binding.recycler.setAdapter(adapter);
        binding.recycler.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (enableLoadMore && newState == RecyclerView.SCROLL_STATE_IDLE) {
                    int lastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();

                    if (!adapter.isEmpty() && !isLoadMore && lastVisibleItemPosition == adapter.getItemCount() - 1) {
                        isLoadMore = true;
                        Log.e("tag", "loadmore");
                        HttpUtils.loadCommunityDatas(type, page, BaseQuFragment.this);
                    }
                }
            }
        });
        binding.recycler.setOnItemClickListener(this);

    }

    @Override
    public void onRefresh() {
        loadFirst();
    }

    private void loadFirst() {
        page = 1;
        if (!binding.swip.isRefreshing()) {
            binding.swip.setRefreshing(true);
        }
        HttpUtils.loadCommunityDatas(type, page, this);
    }

    @Override
    public void loadSuccess(List<CommunityBean.DataBean.ListBean> listBeen, int type) {
        Toast.makeText(a, "成功", Toast.LENGTH_SHORT).show();
        switch (type) {
            case HttpUtils.TYPE_REFLASH_SUCCESS:
                adapter.updateDataSource(null);
                binding.swip.setRefreshing(false);
                page++;
                adapter.updateDataSource(listBeen);
                enableLoadMore(true);
                break;
            case HttpUtils.TYPE_LOAD_MORE_SUCCESS:
                page++;
                adapter.updateDataSource(listBeen);
                isLoadMore = false;
                break;
            case HttpUtils.TYPE_LOAD_MORE_NODATA:
                adapter.removeFooterView();
                enableLoadMore(false);
                break;
        }
    }

    void enableLoadMore(boolean enable) {
        this.enableLoadMore = enable;
    }

    @Override
    public void loadError(String msg, int type) {
        switch (type) {
            case HttpUtils.TYPE_LOAD_MORE_FAILED:
                isLoadMore = false;
            case HttpUtils.TYPE_REFLASH_FAILED:
                binding.swip.setRefreshing(false);
                Toast.makeText(a, "加载失败-->" + msg, Toast.LENGTH_SHORT).show();
                break;

        }
    }

    @Override
    public void onItemClick(RecyclerView recyclerView, View view, int position) {
        CommunityBean.DataBean.ListBean itemAtPosition = adapter.getItemAtPosition(position);
        if (itemAtPosition != null) {
            onItemClick(itemAtPosition);
        }

    }

    protected void onItemClick(CommunityBean.DataBean.ListBean bean) {
    }

    ;
}
