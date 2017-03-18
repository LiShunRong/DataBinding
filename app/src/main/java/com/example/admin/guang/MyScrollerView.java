package com.example.admin.guang;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by admin on 2017/3/19.
 */

public class MyScrollerView extends ScrollView {
    private OnScrollerListener listener;

    public MyScrollerView(Context context) {
        super(context);
    }

    public MyScrollerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public interface  OnScrollerListener{
        void onScroll();
    }
    public void setOnScrollListener(OnScrollerListener listener){
        this.listener=listener;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if(listener!=null){
            listener.onScroll();
        }
    }
}
