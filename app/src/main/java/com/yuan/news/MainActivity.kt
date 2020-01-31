package com.yuan.news

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.google.gson.Gson
import com.google.gson.JsonParser
import com.yuan.news.adapter.NewsListViewAdapter
import com.yuan.news.bean.DataBean
import com.yuan.news.bean.KotlinDataBean
import com.yuan.news.bean.NewsResult
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response
import java.io.IOException

class MainActivity : BaseActivity() {
    val TAG: String = this.javaClass.simpleName

    val instance by lazy { this }

    var list: ArrayList<DataBean>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestNews()
        val data = listOf("Kotlin", "Java", "C++", "Javascript", "Python")
        if (list == null) {

        } else {
            val listViewAdapter = NewsListViewAdapter(instance, R.layout.item_title, list)
            listView.adapter = listViewAdapter
        }
    }

    override fun getContentView(): Int {
        return R.layout.activity_main
    }

    fun requestNews() {
        HttpMethod.getInstance().sendRequest(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                Log.d(TAG, "onFailure")
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call, response: Response) {
                Log.d(TAG, response.body!!.string())
//                val list = Gson().fromJson(response.body.toString(), NewsResult::class.java).result.getData()
//                Log.d(TAG, "" + list.size)
//                for (singleList in list) println(singleList.author_name)
            }
        })
    }

}
