package com.yuan.news.bean

/**
 *yuan
 *2020/2/17
 **/
data class NewsData(
    val error_code: Int,
    val reason: String,
    val result: Result
)

data class Result(
    val `data`: List<Data>,
    val stat: String
)

data class Data(
    val author_name: String,
    val category: String,
    val date: String,
    val thumbnail_pic_s: String,
    val title: String,
    val uniquekey: String,
    val url: String
)