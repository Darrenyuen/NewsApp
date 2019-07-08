package com.example.yuan.newsapp.util;

import com.example.yuan.newsapp.Bean.NewsBean;
import com.google.gson.Gson;

public class ParseUtil {
    public static NewsBean paresJsonWithGson(final String requestText) {
        Gson gson = new Gson();
        return gson.fromJson(requestText, NewsBean.class);
    }
}
