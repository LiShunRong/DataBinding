package com.example.admin.guang;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Html;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.example.admin.guang.adapter.CommentRecyclerAdapter;
import com.example.admin.guang.annoation.ActivityFragmentAnnoation;
import com.example.admin.guang.base.BaseActivity;
import com.example.admin.guang.databinding.ActivityDetailsBinding;
import com.example.admin.guang.service.OnLoadDataFinishListener;
import com.example.admin.guang.utils.HttpUtils;

import java.util.concurrent.ExecutionException;

@ActivityFragmentAnnoation(contentId = R.layout.activity_details)
public class DetailsActivity extends BaseActivity<ActivityDetailsBinding> implements OnLoadDataFinishListener<DetailsBean>, SwipeRefreshLayout.OnRefreshListener, MyScrollerView.OnScrollerListener {
    boolean isLoading = false;
    boolean enableLoad = false;
    OnLoadDataFinishListener<CommentBean> commentBeanOnLoadDataFinishListener = new OnLoadDataFinishListener<CommentBean>() {
        @Override
        public void loadSuccess(CommentBean commentBean, int page) {
            if (page == HttpUtils.TYPE_LOAD_MORE_NODATA) {
                // 禁止
                enableLoad = false;
                commentRecyclerAdapter.removeFooterView();
                return;
            }

            DetailsActivity.this.page++;
            enableLoad = true;
            isLoading = false;
            commentRecyclerAdapter.updateDataSource(commentBean.getData().getComment_list());
        }

        @Override
        public void loadError(String msg, int page) {
            Toast.makeText(DetailsActivity.this, "评论" + msg, Toast.LENGTH_SHORT).show();
            isLoading = false;
        }
    };
    private int id;
    private CommentRecyclerAdapter commentRecyclerAdapter;

    @Override
    protected void initActivityImpl() {
        binding.swip.setOnRefreshListener(this);
        binding.setManager(new LinearLayoutManager(this));
        commentRecyclerAdapter = new CommentRecyclerAdapter(this);
        binding.setAdapter(commentRecyclerAdapter);
        binding.sv.setOnScrollListener(this);
        loadData();
    }

    private void loadData() {
        binding.swip.setRefreshing(true);
        id = getIntent().getIntExtra("id", 0);
        HttpUtils.loadDeatilsData(id + "", this);
    }

    @Override
    public void loadSuccess(DetailsBean detailsBean, int page) {
        DetailsBean.InfoBean info = detailsBean.getData().getInfo();
        binding.setInfobean(info);
        binding.swip.setRefreshing(false);
        binding.swip.setEnabled(false);
        binding.wv.loadDataWithBaseURL(null, info.getContent(), "text/html", "utf-8", "");
        binding.wv.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                loadMore();
            }
        });
    }

    int page = 1;

    private void loadMore() {
        HttpUtils.loadComments(id, page, commentBeanOnLoadDataFinishListener);
    }


    @Override
    public void loadError(String msg, int page) {
        Toast.makeText(this, "" + msg, Toast.LENGTH_SHORT).show();
        binding.swip.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        loadData();
    }


    @Override
    public void onScroll() {
        int scrollY = binding.sv.getScrollY();
        if (scrollY + binding.sv.getHeight() == binding.sv.getChildAt(0).getHeight()) {
            if (enableLoad) {
                if (!isLoading) {
                    isLoading = true;
                    loadMore();
                }
            }
        }
    }
}
