package com.yuan.news.retrofitApi

import com.yuan.news.bean.NewsData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *yuan
 *2020/2/17
 **/
interface GetNews {
    @GET("index")
    fun getNews(@Query("type") type: String, @Query("key") key: String): Call<NewsData>
}