package com.example.admin.guang.service;

import com.example.admin.guang.UpDownBean;
import com.example.admin.guang.utils.UpDown;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by admin on 2017/3/17.
 */

public interface UpDownService {
    @Headers({"sign:e36db3569ac77938ea700ed315817ec0",
            "Authorization:8a817deda9d29b4cb23ab3a898f6e0ac",
            "App-Agent:version=3.2.0,platform=android,app_store_name=zapp-wandoujia,software_version=6.0,models=Custom Phone - 6.0.0 - API 23 - 768x1280,package_name=com.weishang.qwapp,time=1489484134207\n"
    })
    @FormUrlEncoded
    @POST("community/likeorhate/{id}")
    Call<UpDownBean> getUpDownState(@Path("id") String id, @Field("type") int type, @Field("type_value") int typeValue);
}
