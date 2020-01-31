package com.yuan.news

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonParser
import com.yuan.news.bean.NewsResult
import okhttp3.*
import java.io.IOException

/**
 *yuan
 *2020/1/30
 **/
class HttpMethod {

    private val TAG : String = this.javaClass.simpleName

    private val baseurl : String = "http://v.juhe.cn/toutiao/index?type=top&key=c9bafcd7aff837f20267aa453ff843e4"

    companion object {

        private val inStance : HttpMethod = HttpMethod()

        fun getInstance() : HttpMethod {
            return inStance
        }
    }

    private val client = OkHttpClient.Builder().build()
    private val request = Request.Builder()
        .url(baseurl)
        .get()
        .build()

    fun sendRequest(callback: Callback) {
        client.newCall(request).enqueue(callback)
    }
}