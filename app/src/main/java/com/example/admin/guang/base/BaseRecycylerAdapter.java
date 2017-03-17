package com.example.admin.guang.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.guang.databinding.LayoutFooterBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * 1个view  一个type;
 */

public abstract class BaseRecycylerAdapter<T> extends RecyclerView.Adapter<BaseHolder> {
    List<T> list = new ArrayList<>();
    Context ctx;
    List<View> footerViews = new ArrayList<>();
    View footerView;
    int TYPEFOOTER = 100;
    protected LayoutInflater inflater;

    public BaseRecycylerAdapter(Context ctx) {
        this.ctx = ctx;
        inflater = LayoutInflater.from(ctx);
        footerView = LayoutFooterBinding.inflate(LayoutInflater.from(ctx)).getRoot();
        footerView.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        init();
    }

    public T getItemAtPosition(int position) {
        if (position >= list.size()) return null;
        return list.get(position);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public void updateDataSource(List<T> list) {
        if (list == null) {
            this.list.clear();
        } else {
            this.list.addAll(list);
        }
        notifyDataSetChanged();
    }

    private void init() {
        footerViews.add(footerView);
    }


    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPEFOOTER) {
            return new BaseHolder(footerView);
        }
        return onCreateChildViewHolder(parent, viewType);
    }

    protected abstract BaseHolder onCreateChildViewHolder(ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(BaseHolder holder, int position) {
        if (position >= 0 && position < list.size())
            holder.bind(list.get(position));
    }


    @Override
    public int getItemCount() {
        return list.size() == 0 ? 0 : list.size() + footerViews.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == list.size()) return TYPEFOOTER;
        return getChildItemViewType(position);
    }

    protected abstract int getChildItemViewType(int position);

    public void addFooterView(View footView) {
        footerViews.add(footView);
        update();
    }


    private void update() {
        notifyDataSetChanged();
    }

    public void removeFooterView() {
        footerViews.remove(footerView);
        update();
    }


}
