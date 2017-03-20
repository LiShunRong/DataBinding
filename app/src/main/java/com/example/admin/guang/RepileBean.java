package com.example.admin.guang;

/**
 * Created by admin on 2017/3/20.
 */

public class RepileBean {

    /**
     * code : 200
     * message : 回复成功
     * data : {"id":11611,"user_id":0,"nickname":"来至Custom Phone - 6.0.0 - API 23 - 768x1280的基友","reply_content":"sadasasdasdasdas"}
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
         * id : 11611
         * user_id : 0
         * nickname : 来至Custom Phone - 6.0.0 - API 23 - 768x1280的基友
         * reply_content : sadasasdasdasdas
         */

        private int id;
        private int user_id;
        private String nickname;
        private String reply_content;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getReply_content() {
            return reply_content;
        }

        public void setReply_content(String reply_content) {
            this.reply_content = reply_content;
        }
    }
}
