package com.example.admin.guang;

/**
 * Created by admin on 2017/3/17.
 */

public class UpDownBean {

    /**
     * code : 200
     * message : 赞成功
     * data : {}
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
    }

    @Override
    public String toString() {
        return "UpDownBean{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
