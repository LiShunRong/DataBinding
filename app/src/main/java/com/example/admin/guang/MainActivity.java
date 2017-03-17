package com.example.admin.guang;

import android.util.Log;

import com.example.admin.guang.adapter.QuFragmnetAdapter;
import com.example.admin.guang.annoation.ActivityFragmentAnnoation;
import com.example.admin.guang.base.BaseActivity;
import com.example.admin.guang.databinding.ActivityMainBinding;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@ActivityFragmentAnnoation(contentId = R.layout.activity_main)
public class MainActivity extends BaseActivity<ActivityMainBinding> {
    @Override
    protected void initActivityImpl() {
        binding.setAdapter(new QuFragmnetAdapter(getSupportFragmentManager()));
    }
}
