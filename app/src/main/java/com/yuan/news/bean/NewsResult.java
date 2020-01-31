package com.yuan.news.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * yuan
 * 2020/1/30
 **/
public class NewsResult {

    /**
     * reason : 成功的返回
     * error_code : 0
     */

    @SerializedName("reason")
    public String reason;
    @SerializedName("result")
    public ResultBean result;
    @SerializedName("error_code")
    public int errorCode;

    public static class ResultBean {
        /**
         * stat : 1
         */

        @SerializedName("stat")
        public String stat;
        @SerializedName("data")
        public List<DataBean> data;

        public List<DataBean> getData() {
            return data;
        }

        public static class DataBean {
            /**
             * uniquekey : 3e9891efd4330063d6bdc1012f7c56d8
             * title : 黄冈市被免职主任回应:服从组织安排 公道自在人心
             * date : 2020-01-31 21:20
             * category : 头条
             * author_name : 红星新闻
             * url : http://mini.eastday.com/mobile/200131212054987.html
             * thumbnail_pic_s : http://08imgmini.eastday.com/mobile/20200131/20200131212054_c45649ce6a98561dae6e9096ec4b3f88_1_mwpm_03200403.jpg
             * thumbnail_pic_s02 : http://01imgmini.eastday.com/mobile/20200131/20200131212041_7fa4d9e95aa55786678100c66c84e29a_4_mwpm_03200403.jpg
             * thumbnail_pic_s03 : http://01imgmini.eastday.com/mobile/20200131/20200131212041_7fa4d9e95aa55786678100c66c84e29a_6_mwpm_03200403.jpg
             */

            @SerializedName("uniquekey")
            public String uniquekey;
            @SerializedName("title")
            public String title;
            @SerializedName("date")
            public String date;
            @SerializedName("category")
            public String category;
            @SerializedName("author_name")
            public String authorName;
            @SerializedName("url")
            public String url;
            @SerializedName("thumbnail_pic_s")
            public String thumbnailPicS;
            @SerializedName("thumbnail_pic_s02")
            public String thumbnailPicS02;
            @SerializedName("thumbnail_pic_s03")
            public String thumbnailPicS03;
        }
    }
}
