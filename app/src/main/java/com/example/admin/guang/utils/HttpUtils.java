package com.example.admin.guang.utils;

import android.content.Context;
import android.util.Log;

import com.example.admin.guang.CommentBean;
import com.example.admin.guang.CommunityBean;
import com.example.admin.guang.DetailsBean;
import com.example.admin.guang.MyApplication;
import com.example.admin.guang.UpDownBean;
import com.example.admin.guang.service.CommentService;
import com.example.admin.guang.service.CommunityService;
import com.example.admin.guang.service.DetailsService;
import com.example.admin.guang.service.OnLoadDataFinishListener;
import com.example.admin.guang.service.UpDownService;
import com.example.admin.guang.service.VideoService;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by admin on 2017/3/14.
 */

public class HttpUtils {
    public static final int TYPE_REFLASH_SUCCESS = 1;
    public static final int TYPE_REFLASH_FAILED = 2;
    public static final int TYPE_LOAD_MORE_SUCCESS = 3;
    public static final int TYPE_LOAD_MORE_FAILED = 4;
    public static final int TYPE_LOAD_MORE_NODATA = 5;
    public static final int TYPE_UNNOKNED = -1;

    public static void loadCommunityDatas(String type, final int page, final OnLoadDataFinishListener<List<CommunityBean.DataBean.ListBean>> listOnLoadDataFinishListener) {
        MyApplication.retrofit.create(CommunityService.class).getDatas(type, page).enqueue(new Callback<CommunityBean>() {

            @Override
            public void onResponse(Call<CommunityBean> call, Response<CommunityBean> response) {
                try {
                    List<CommunityBean.DataBean.ListBean> list = response.body().getData().getList();
                    listOnLoadDataFinishListener.loadSuccess(list, getType(list, page));
                } catch (Exception e) {
                    e.printStackTrace();
                    listOnLoadDataFinishListener.loadError(e.getMessage(), getType(null, page));
                }
            }

            @Override
            public void onFailure(Call<CommunityBean> call, Throwable t) {
                t.printStackTrace();
                listOnLoadDataFinishListener.loadError(t.getMessage(), getType(null, page));
            }
        });

    }

    public static void loadVideoData(String videoUrl, final OnLoadDataFinishListener<VideoBean> onLoadDataFinishListener) {
        MyApplication.retrofit.create(VideoService.class).getVideoData(videoUrl).enqueue(new Callback<VideoBean>() {
            @Override
            public void onResponse(Call<VideoBean> call, Response<VideoBean> response) {
                VideoBean body = response.body();
                onLoadDataFinishListener.loadSuccess(body, 0);
            }

            @Override
            public void onFailure(Call<VideoBean> call, Throwable t) {
                onLoadDataFinishListener.loadError(t.getMessage(), 0);
            }
        });
    }
    public static void updown(String id, int type, int typeValue, final OnLoadDataFinishListener<UpDownBean> listener){
        MyApplication.retrofit.create(UpDownService.class).getUpDownState(id,type,typeValue).enqueue(new Callback<UpDownBean>() {

            @Override
            public void onResponse(Call<UpDownBean> call, Response<UpDownBean> response) {
                if(response.isSuccessful()) {
                    listener.loadSuccess(response.body(), 0);
                }else {
                    try {
                        String string = response.errorBody().string();
                        listener.loadSuccess(new Gson().fromJson(string,UpDownBean.class),0);
                    } catch (IOException e) {
                        e.printStackTrace();
                        listener.loadError(e.getMessage(),0);
                    }
                }
            }

            @Override
            public void onFailure(Call<UpDownBean> call, Throwable t) {
                listener.loadError(t.getMessage(),0);
            }
        });
    }
    public static void loadDeatilsData(String id, final OnLoadDataFinishListener<DetailsBean> loadDataFinishListener){
        MyApplication.retrofit.create(DetailsService.class).getDetails(id).enqueue(new Callback<DetailsBean>() {
            @Override
            public void onResponse(Call<DetailsBean> call, Response<DetailsBean> response) {
                if(response.isSuccessful()){
                    loadDataFinishListener.loadSuccess(response.body(),0);
                }else {
                    try {
                        loadDataFinishListener.loadError(response.errorBody().string(),0);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<DetailsBean> call, Throwable t) {
            loadDataFinishListener.loadError(t.getMessage(),0);
            }
        });
    }
    public static void loadComments(int id, final int page , final OnLoadDataFinishListener<CommentBean> commentBeanOnLoadDataFinishListener){
        MyApplication.retrofit.create(CommentService.class).getComments(id,page+"").enqueue(new Callback<CommentBean>() {
            @Override
            public void onResponse(Call<CommentBean> call, Response<CommentBean> response) {
                if(response.isSuccessful()){
                    CommentBean body = response.body();
                    commentBeanOnLoadDataFinishListener.loadSuccess(body,getType(body.getData().getComment_list(),page));

                }else {
                    try {
                        commentBeanOnLoadDataFinishListener.loadError(response.errorBody().string(),getType(null,page));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<CommentBean> call, Throwable t) {
            commentBeanOnLoadDataFinishListener.loadError(t.getMessage(),getType(null,page));
            }
        });
    }
    private static int getType(List list, int page) {
        if (list == null && page == 1) {
            return TYPE_REFLASH_FAILED;
        }
        if (list == null && page > 1) {
            return TYPE_LOAD_MORE_FAILED;
        }
        if (list.size() == 0) {
            return TYPE_LOAD_MORE_NODATA;
        }
        if (list.size() > 0 && page == 1) {
            return TYPE_REFLASH_SUCCESS;
        }
        if (list.size() > 0 && page > 1) {
            return TYPE_LOAD_MORE_SUCCESS;
        }
        return TYPE_UNNOKNED;

    }

    ;
}
