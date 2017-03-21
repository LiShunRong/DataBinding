package com.example.admin.guang;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
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
    private GestureDetector gestureDetector;

    @Override
    protected void initActivityImpl() {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setAttributes(attributes);
        videoUrl = getIntent().getStringExtra("videoUrl");
        binding.vv.setBackgroundColor(Color.BLACK);
        gestureDetector = new GestureDetector(new SimpleListener());
        loadData();
    }
    class SimpleListener extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onDoubleTap(MotionEvent e) {
            toggleOriention();
            return true;
        }

    }

    private void toggleOriention() {
        int requestedOrientation = getRequestedOrientation();
        Log.e("tags",requestedOrientation+"");
        if(requestedOrientation==ActivityInfo.SCREEN_ORIENTATION_PORTRAIT){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean b = gestureDetector.onTouchEvent(ev);
        if(b){
            return false;
        }
        return super.dispatchTouchEvent(ev);
    }

    private void loadData() {
        binding.pb.setVisibility(View.VISIBLE);
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
        binding.pb.setVisibility(View.GONE);
        binding.vv.setBackgroundColor(Color.TRANSPARENT);
    }

    @Override
    public void onBackPressed() {
        boolean b = getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
        if(b){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            return;
        }
        super.onBackPressed();
    }
}
