package com.example.admin.guang;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.Toast;

import com.example.admin.guang.annoation.ActivityFragmentAnnoation;
import com.example.admin.guang.base.BaseActivity;
import com.example.admin.guang.databinding.ActivityVideoBinding;
import com.example.admin.guang.service.OnLoadDataFinishListener;
import com.example.admin.guang.utils.HttpUtils;
import com.example.admin.guang.utils.VideoBean;

/**
 * Created by admin on 2017/3/15.
 */
@ActivityFragmentAnnoation(contentId = R.layout.activity_video)
public class VideoActivity extends BaseActivity<ActivityVideoBinding> implements OnLoadDataFinishListener<VideoBean>, MediaPlayer.OnPreparedListener {
    String videoUrl;

    @Override
    protected void initActivityImpl() {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setAttributes(attributes);
        videoUrl = getIntent().getStringExtra("videoUrl");
        binding.vv.setBackgroundColor(Color.BLACK);
        loadData();
    }

    private void loadData() {
        HttpUtils.loadVideoData(videoUrl, this);
    }

    @Override
    public void loadSuccess(VideoBean videoBean, int page) {
        String video_analysis_url = videoBean.getData().getVideo_analysis_url();
        binding.vv.setVideoPath(video_analysis_url);
        binding.vv.setOnPreparedListener(this);
        MediaController mediaController = new MediaController(this);
        binding.vv.setMediaController(mediaController);
    }

    @Override
    public void loadError(String msg, int page) {
        Toast.makeText(this, "" + msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();

        binding.vv.setBackgroundColor(Color.TRANSPARENT);
    }

}
