package com.example.admin.guang.utils;

/**
 * Created by admin on 2017/3/15.
 */

public class VideoBean {

    /**
     * code : 200
     * message :
     * data : {"video_analysis_url":"http://mvvideo2.meitudata.com/58946a189b38d280.mp4"}
     */
    private int code;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * video_analysis_url : http://mvvideo2.meitudata.com/58946a189b38d280.mp4
         */

        private String video_analysis_url;

        public String getVideo_analysis_url() {
            return video_analysis_url;
        }

        public void setVideo_analysis_url(String video_analysis_url) {
            this.video_analysis_url = video_analysis_url;
        }
    }
}
