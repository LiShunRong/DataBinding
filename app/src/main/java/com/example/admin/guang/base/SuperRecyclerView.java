package com.example.admin.guang.base;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by admin on 2017/3/14.
 */

public class SuperRecyclerView extends RecyclerView {

    private GestureDetector gestureDetector;
    private OnItemClickListener listener;

    public SuperRecyclerView(Context context) {
        super(context);
        init();
    }

    private void init() {
        gestureDetector = new GestureDetector(new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                if (listener != null) {
                    float x = e.getX();
                    float y = e.getY();
                    View childViewUnder = findChildViewUnder(x, y);
                    int position = -1;
                    if (childViewUnder != null) {
                        ViewHolder containingViewHolder = findContainingViewHolder(childViewUnder);
                        position = containingViewHolder.getAdapterPosition();
                    }
                    if (position != -1) {
                        listener.onItemClick(SuperRecyclerView.this, childViewUnder, position);
                    }
                }

                return super.onSingleTapUp(e);
            }
        });
    }

    public interface OnItemClickListener {
        void onItemClick(RecyclerView recyclerView, View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public SuperRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SuperRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        gestureDetector.onTouchEvent(e);
        return super.onTouchEvent(e);
    }
}
