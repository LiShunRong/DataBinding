package com.example.admin.guang;

import java.util.List;

/**
 * Created by admin on 2017/3/18.
 */

public class CommentBean {
    /**
     * code : 200
     * message :
     * data : {"comment_list":[{"content":"长期出售网盘资源看啪，空姐波多野结衣苍井空人妻，乱伦sm等等直接，赶紧打开威信伽我吧，威信：qw8101111","created_at":1489845667,"id":285411,"reply_number":0,"praise_count":0,"is_praise":2,"other_name":"看簧片加我微信","avatar":"http://img.api.m.qu.cn/images/api/20170318/0d22110c192e9616fc3784104b504523.jpeg","replies":[],"pictures":[]},{"content":"每月20元看视频你们懂得！国美、日韩、动画等类型每天保证最少200部每天不重复➕威信：pan19901010诚信为本，老店了：","created_at":1489844425,"id":285266,"reply_number":0,"praise_count":0,"is_praise":2,"other_name":"会员_iGub","avatar":"","replies":[],"pictures":[]},{"content":"哦哦哦哦噢哇啊啊啊撒撒撒","created_at":1489842473,"id":285241,"reply_number":0,"praise_count":0,"is_praise":2,"other_name":"会员_KcqM","avatar":"","replies":[],"pictures":[]},{"content":"哈哈哈哈哈哈哈哈哈哈","created_at":1489841861,"id":285226,"reply_number":0,"praise_count":0,"is_praise":2,"other_name":"会员_lXki","avatar":"","replies":[],"pictures":[]},{"content":"女的都是我说过彪悍的人生","created_at":1489841321,"id":285221,"reply_number":0,"praise_count":0,"is_praise":2,"other_name":"会员_GkFM","avatar":"","replies":[],"pictures":[]},{"content":"手机黃网：VX４４４.соМ人与动物,美女脱衣,妹妹好痒!","created_at":1489839822,"id":285186,"reply_number":0,"praise_count":1,"is_praise":2,"other_name":"会员_f0Hu","avatar":"http://img.api.m.qu.cn/images/api/20170317/d905dd903a0a90efbeb3cdc227ba1565.jpeg","replies":[],"pictures":[]},{"content":"我今年\u201c高龄\u201d29，再过上几个月，就是三十岁的人了。","created_at":1489837439,"id":284426,"reply_number":0,"praise_count":0,"is_praise":2,"other_name":"会员_xKLi","avatar":"http://img.api.m.qu.cn/images/api/20161209/e1cf008b8eef004b54f6aff7c3c841fb.jpeg","replies":[],"pictures":[]},{"content":"长期出售网盘资源，看啪。空姐少妇丝袜**人妻，乱伦等等。。。薇：qw8101111","created_at":1489832745,"id":284336,"reply_number":2,"praise_count":0,"is_praise":2,"other_name":"看簧片加我微信","avatar":"http://img.api.m.qu.cn/images/api/20170318/0d22110c192e9616fc3784104b504523.jpeg","replies":[{"other_name":"会员_GkFM","avatar":"","content":"你的代我说我要去不去想"},{"other_name":"东方红_406684","avatar":"","content":"我是一个爱性生活的人我原加一、"}],"pictures":[]},{"content":"每月20元看视频你们懂得！国美、日韩、动画等类型每天保证最少200部每天不重复➕威信：pan19901010诚信为本，老店呀","created_at":1489831304,"id":284176,"reply_number":0,"praise_count":0,"is_praise":2,"other_name":"会员_iGub","avatar":"","replies":[],"pictures":[]},{"content":"是的说的太对了，她们很寂寞","created_at":1489831011,"id":284171,"reply_number":0,"praise_count":0,"is_praise":2,"other_name":"廉贞","avatar":"","replies":[],"pictures":[]}],"page_total":3,"c_total":26,"c_page_next":2}
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
         * comment_list : [{"content":"长期出售网盘资源看啪，空姐波多野结衣苍井空人妻，乱伦sm等等直接，赶紧打开威信伽我吧，威信：qw8101111","created_at":1489845667,"id":285411,"reply_number":0,"praise_count":0,"is_praise":2,"other_name":"看簧片加我微信","avatar":"http://img.api.m.qu.cn/images/api/20170318/0d22110c192e9616fc3784104b504523.jpeg","replies":[],"pictures":[]},{"content":"每月20元看视频你们懂得！国美、日韩、动画等类型每天保证最少200部每天不重复➕威信：pan19901010诚信为本，老店了：","created_at":1489844425,"id":285266,"reply_number":0,"praise_count":0,"is_praise":2,"other_name":"会员_iGub","avatar":"","replies":[],"pictures":[]},{"content":"哦哦哦哦噢哇啊啊啊撒撒撒","created_at":1489842473,"id":285241,"reply_number":0,"praise_count":0,"is_praise":2,"other_name":"会员_KcqM","avatar":"","replies":[],"pictures":[]},{"content":"哈哈哈哈哈哈哈哈哈哈","created_at":1489841861,"id":285226,"reply_number":0,"praise_count":0,"is_praise":2,"other_name":"会员_lXki","avatar":"","replies":[],"pictures":[]},{"content":"女的都是我说过彪悍的人生","created_at":1489841321,"id":285221,"reply_number":0,"praise_count":0,"is_praise":2,"other_name":"会员_GkFM","avatar":"","replies":[],"pictures":[]},{"content":"手机黃网：VX４４４.соМ人与动物,美女脱衣,妹妹好痒!","created_at":1489839822,"id":285186,"reply_number":0,"praise_count":1,"is_praise":2,"other_name":"会员_f0Hu","avatar":"http://img.api.m.qu.cn/images/api/20170317/d905dd903a0a90efbeb3cdc227ba1565.jpeg","replies":[],"pictures":[]},{"content":"我今年\u201c高龄\u201d29，再过上几个月，就是三十岁的人了。","created_at":1489837439,"id":284426,"reply_number":0,"praise_count":0,"is_praise":2,"other_name":"会员_xKLi","avatar":"http://img.api.m.qu.cn/images/api/20161209/e1cf008b8eef004b54f6aff7c3c841fb.jpeg","replies":[],"pictures":[]},{"content":"长期出售网盘资源，看啪。空姐少妇丝袜**人妻，乱伦等等。。。薇：qw8101111","created_at":1489832745,"id":284336,"reply_number":2,"praise_count":0,"is_praise":2,"other_name":"看簧片加我微信","avatar":"http://img.api.m.qu.cn/images/api/20170318/0d22110c192e9616fc3784104b504523.jpeg","replies":[{"other_name":"会员_GkFM","avatar":"","content":"你的代我说我要去不去想"},{"other_name":"东方红_406684","avatar":"","content":"我是一个爱性生活的人我原加一、"}],"pictures":[]},{"content":"每月20元看视频你们懂得！国美、日韩、动画等类型每天保证最少200部每天不重复➕威信：pan19901010诚信为本，老店呀","created_at":1489831304,"id":284176,"reply_number":0,"praise_count":0,"is_praise":2,"other_name":"会员_iGub","avatar":"","replies":[],"pictures":[]},{"content":"是的说的太对了，她们很寂寞","created_at":1489831011,"id":284171,"reply_number":0,"praise_count":0,"is_praise":2,"other_name":"廉贞","avatar":"","replies":[],"pictures":[]}]
         * page_total : 3
         * c_total : 26
         * c_page_next : 2
         */

        private int page_total;
        private int c_total;
        private int c_page_next;
        private List<CommentListBean> comment_list;

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

        public List<CommentListBean> getComment_list() {
            return comment_list;
        }

        public void setComment_list(List<CommentListBean> comment_list) {
            this.comment_list = comment_list;
        }

        public static class CommentListBean {
            /**
             * content : 长期出售网盘资源看啪，空姐波多野结衣苍井空人妻，乱伦sm等等直接，赶紧打开威信伽我吧，威信：qw8101111
             * created_at : 1489845667
             * id : 285411
             * reply_number : 0
             * praise_count : 0
             * is_praise : 2
             * other_name : 看簧片加我微信
             * avatar : http://img.api.m.qu.cn/images/api/20170318/0d22110c192e9616fc3784104b504523.jpeg
             * replies : []
             * pictures : []
             */

            private String content;
            private int created_at;
            private int id;
            private int reply_number;
            private int praise_count;
            private int is_praise;
            private String other_name;
            private String avatar;
            private List<RepileBean> replies;
            private List<?> pictures;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getCreated_at() {
                return created_at;
            }

            public void setCreated_at(int created_at) {
                this.created_at = created_at;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getReply_number() {
                return reply_number;
            }

            public void setReply_number(int reply_number) {
                this.reply_number = reply_number;
            }

            public int getPraise_count() {
                return praise_count;
            }

            public void setPraise_count(int praise_count) {
                this.praise_count = praise_count;
            }

            public int getIs_praise() {
                return is_praise;
            }

            public void setIs_praise(int is_praise) {
                this.is_praise = is_praise;
            }

            public String getOther_name() {
                return other_name;
            }

            public void setOther_name(String other_name) {
                this.other_name = other_name;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public List<RepileBean> getReplies() {
                return replies;
            }

            public void setReplies(List<RepileBean> replies) {
                this.replies = replies;
            }

            public List<?> getPictures() {
                return pictures;
            }

            public void setPictures(List<?> pictures) {
                this.pictures = pictures;
            }
        }
    }
    public static class RepileBean{
        private String content;
        private String other_name;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getOther_name() {
            return other_name;
        }

        public void setOther_name(String other_name) {
            this.other_name = other_name;
        }
    }
}
