package com.example.admin.guang;

/**
 * Created by admin on 2017/3/17.
 */

public class DetailsBean {
    private int code;
    private String message;
    private  DataBean data;

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

  public   static  class DataBean{
        private InfoBean info;

        public InfoBean getInfo() {
            return info;
        }

        public void setInfo(InfoBean info) {
            this.info = info;
        }
    }
   public static class InfoBean{
        private int author_id;
        private String author_img;
        private String author_name;
        private int comment_count;
        private String content;
        private String cover_img;
        private  int id;
        private int is_like;
        private int praise_count;
        private long send_time;
        private String title;

        public int getAuthor_id() {
            return author_id;
        }

        public void setAuthor_id(int author_id) {
            this.author_id = author_id;
        }

        public String getAuthor_img() {
            return author_img;
        }

        public void setAuthor_img(String author_img) {
            this.author_img = author_img;
        }

        public String getAuthor_name() {
            return author_name;
        }

        public void setAuthor_name(String author_name) {
            this.author_name = author_name;
        }

        public int getComment_count() {
            return comment_count;
        }

        public void setComment_count(int comment_count) {
            this.comment_count = comment_count;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getConver_img() {
            return cover_img;
        }

        public void setConver_img(String conver_img) {
            this.cover_img = conver_img;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getIs_like() {
            return is_like;
        }

        public void setIs_like(int is_like) {
            this.is_like = is_like;
        }

        public int getPraise_count() {
            return praise_count;
        }

        public void setPraise_count(int praise_count) {
            this.praise_count = praise_count;
        }

        public long getSend_time() {
            return send_time;
        }

        public void setSend_time(long send_time) {
            this.send_time = send_time;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
