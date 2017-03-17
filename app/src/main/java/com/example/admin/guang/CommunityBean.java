package com.example.admin.guang;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.List;

/**
 * Created by admin on 2017/3/14.
 */

public class CommunityBean {

    /**
     * code : 200
     * message :
     * data : {"list":[{"id":1751,"title":"周六 · 故事\u2014\u2014和表哥翻滚的三生三世","cover_img":"http://img.api.m.qu.cn/images/api/20170303/ef857893c852decc024703012ae4ef85.jpeg","img_height":358,"img_with":640,"praise_count":100,"comment_count":30},{"id":1756,"title":"周五 · 情感\u2014\u2014什么心直口快，你只是没教养而已","cover_img":"http://img.api.m.qu.cn/images/api/20170303/df8d963832ece848f4f3fed832f8e10d.jpeg","img_height":358,"img_with":640,"praise_count":84,"comment_count":24},{"id":1746,"title":"周四 · 发现\u2014\u2014介绍一个\u201c可以约炮\u201d的网站给大家","cover_img":"http://img.api.m.qu.cn/images/api/20170302/45ae80821ab021e9294f529337103d12.jpeg","img_height":358,"img_with":640,"praise_count":171,"comment_count":30},{"id":1741,"title":"周三 · 知识\u2014\u2014AV后遗症：把爱放在性的前面","cover_img":"http://img.api.m.qu.cn/images/api/20170301/517936f17dc23ddc1f47d1938ca2172a.jpeg","img_height":358,"img_with":640,"praise_count":132,"comment_count":27},{"id":1736,"title":"周二 · 干货\u2014\u2014都是撸，不如换个装备升个级","cover_img":"http://img.api.m.qu.cn/images/api/20170228/5cbb23d76e7a8ed46c40e6d037193875.jpeg","img_height":358,"img_with":640,"praise_count":94,"comment_count":32},{"id":1731,"title":"周一 · 技巧\u2014\u2014边进出边摸豆？女票说没感觉！","cover_img":"http://img.api.m.qu.cn/images/api/20170227/16ee39191cb45720849f998aaa217862.jpeg","img_height":358,"img_with":640,"praise_count":150,"comment_count":27},{"id":1726,"title":"周日·有料\u2014\u2014这孩子从小就会画鸡鸡，我该怎么办？","cover_img":"http://img.api.m.qu.cn/images/api/20170224/ea48d0345aa4b85529bd0870e8096fc0.jpeg","img_height":358,"img_with":640,"praise_count":122,"comment_count":20},{"id":1711,"title":"周六·故事\u2014\u2014我在床上喘息却换不来你一声老婆","cover_img":"http://img.api.m.qu.cn/images/api/20170223/9324fb687926fdd4c81d1b6154759d7f.jpeg","img_height":358,"img_with":640,"praise_count":185,"comment_count":29},{"id":1716,"title":"周五·情感\u2014\u2014做我女朋友行吗？  不行我再想想办法。","cover_img":"http://img.api.m.qu.cn/images/api/20170223/6d3664d317f9b1561d7df5052cb4730f.jpeg","img_height":358,"img_with":640,"praise_count":74,"comment_count":30},{"id":1721,"title":"高草修炼大法| 如何让她下面变成喷泉？","cover_img":"http://img.api.m.qu.cn/images/api/20170223/d54bea7cde2e07e1c812fc82a68a799b.jpeg","img_height":402,"img_with":558,"praise_count":139,"comment_count":23}],"page_total":32,"c_total":318,"c_page_next":3}
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
         * list : [{"id":1751,"title":"周六 · 故事\u2014\u2014和表哥翻滚的三生三世","cover_img":"http://img.api.m.qu.cn/images/api/20170303/ef857893c852decc024703012ae4ef85.jpeg","img_height":358,"img_with":640,"praise_count":100,"comment_count":30},{"id":1756,"title":"周五 · 情感\u2014\u2014什么心直口快，你只是没教养而已","cover_img":"http://img.api.m.qu.cn/images/api/20170303/df8d963832ece848f4f3fed832f8e10d.jpeg","img_height":358,"img_with":640,"praise_count":84,"comment_count":24},{"id":1746,"title":"周四 · 发现\u2014\u2014介绍一个\u201c可以约炮\u201d的网站给大家","cover_img":"http://img.api.m.qu.cn/images/api/20170302/45ae80821ab021e9294f529337103d12.jpeg","img_height":358,"img_with":640,"praise_count":171,"comment_count":30},{"id":1741,"title":"周三 · 知识\u2014\u2014AV后遗症：把爱放在性的前面","cover_img":"http://img.api.m.qu.cn/images/api/20170301/517936f17dc23ddc1f47d1938ca2172a.jpeg","img_height":358,"img_with":640,"praise_count":132,"comment_count":27},{"id":1736,"title":"周二 · 干货\u2014\u2014都是撸，不如换个装备升个级","cover_img":"http://img.api.m.qu.cn/images/api/20170228/5cbb23d76e7a8ed46c40e6d037193875.jpeg","img_height":358,"img_with":640,"praise_count":94,"comment_count":32},{"id":1731,"title":"周一 · 技巧\u2014\u2014边进出边摸豆？女票说没感觉！","cover_img":"http://img.api.m.qu.cn/images/api/20170227/16ee39191cb45720849f998aaa217862.jpeg","img_height":358,"img_with":640,"praise_count":150,"comment_count":27},{"id":1726,"title":"周日·有料\u2014\u2014这孩子从小就会画鸡鸡，我该怎么办？","cover_img":"http://img.api.m.qu.cn/images/api/20170224/ea48d0345aa4b85529bd0870e8096fc0.jpeg","img_height":358,"img_with":640,"praise_count":122,"comment_count":20},{"id":1711,"title":"周六·故事\u2014\u2014我在床上喘息却换不来你一声老婆","cover_img":"http://img.api.m.qu.cn/images/api/20170223/9324fb687926fdd4c81d1b6154759d7f.jpeg","img_height":358,"img_with":640,"praise_count":185,"comment_count":29},{"id":1716,"title":"周五·情感\u2014\u2014做我女朋友行吗？  不行我再想想办法。","cover_img":"http://img.api.m.qu.cn/images/api/20170223/6d3664d317f9b1561d7df5052cb4730f.jpeg","img_height":358,"img_with":640,"praise_count":74,"comment_count":30},{"id":1721,"title":"高草修炼大法| 如何让她下面变成喷泉？","cover_img":"http://img.api.m.qu.cn/images/api/20170223/d54bea7cde2e07e1c812fc82a68a799b.jpeg","img_height":402,"img_with":558,"praise_count":139,"comment_count":23}]
         * page_total : 32
         * c_total : 318
         * c_page_next : 3
         */

        private int page_total;
        private int c_total;
        private int c_page_next;
        private List<ListBean> list;

        public int getPage_total() {
            return page_total;
        }

        public void setPage_total(int page_total) {
            this.page_total = page_total;
        }

        public int getC_total() {
            return c_total;
        }

        public void setC_total(int c_total) {
            this.c_total = c_total;
        }

        public int getC_page_next() {
            return c_page_next;
        }

        public void setC_page_next(int c_page_next) {
            this.c_page_next = c_page_next;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean  extends BaseObservable{
            /**
             * id : 1751
             * title : 周六 · 故事——和表哥翻滚的三生三世
             * cover_img : http://img.api.m.qu.cn/images/api/20170303/ef857893c852decc024703012ae4ef85.jpeg
             * img_height : 358
             * img_with : 640
             * praise_count : 100
             * comment_count : 30
             */

            private int id;
            private String title;
            private String cover_img;
            private int img_height;
            private int img_with;
            private int praise_count;
            private int comment_count;
            private int author_id;
            private String author_img;
            private String author_name;
            private String content;
            private int is_praise;
            private  int is_step_on;
            private  String vedio_url;

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

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getIs_praise() {
                return is_praise;
            }

            public void setIs_praise(int is_praise) {
                this.is_praise = is_praise;
            }

            public int getIs_step_on() {
                return is_step_on;
            }

            public void setIs_step_on(int is_step_on) {
                this.is_step_on = is_step_on;
            }

            public String getVedio_url() {
                return vedio_url;
            }

            public void setVedio_url(String vedio_url) {
                this.vedio_url = vedio_url;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getCover_img() {
                return cover_img;
            }

            public void setCover_img(String cover_img) {
                this.cover_img = cover_img;
            }

            public int getImg_height() {
                return img_height;
            }

            public void setImg_height(int img_height) {
                this.img_height = img_height;
            }

            public int getImg_with() {
                return img_with;
            }

            public void setImg_with(int img_with) {
                this.img_with = img_with;
            }
            @Bindable
            public int getPraise_count() {
                return praise_count;
            }

            public void setPraise_count(int praise_count) {
                this.praise_count = praise_count;
            }

            public int getComment_count() {
                return comment_count;
            }

            public void setComment_count(int comment_count) {
                this.comment_count = comment_count;
            }
        }
    }
}
