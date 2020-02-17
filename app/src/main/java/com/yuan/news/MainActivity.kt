package com.yuan.news

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yuan.news.adapter.NewsTitleAdapter
import com.yuan.news.adapter.NewsTypeRecyclerViewAdapter
import com.yuan.news.retrofitApi.GetNews
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.CoroutineContext

/**
 * top(头条，默认),shehui(社会),guonei(国内),guoji(国际),yule(娱乐),tiyu(体育)junshi(军事),keji(科技),caijing(财经),shishang(时尚)
 */
class MainActivity : BaseActivity(), CoroutineScope {

//    private val instance by lazy { this }

    private lateinit var job: Job

    //继承CoroutineScope必须初始化coroutineContext变量
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main  //前面表示job,用于控制协程,后面是Dispatchers,指定启动的线程

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        newsTypeRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false) //没有layoutManager会跳过描绘布局
        newsTypeRecyclerView.setBackgroundColor(resources.getColor(R.color.colorPrimary))
        newsTypeRecyclerView.adapter = NewsTypeRecyclerViewAdapter(resources.getStringArray(R.array.newsType))
        job = Job()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://v.juhe.cn/toutiao/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GetNews::class.java)

        launch {
            progressBar.visibility = View.VISIBLE
            val result = withContext(Dispatchers.IO) {
                retrofit.getNews("top", "c9bafcd7aff837f20267aa453ff843e4").execute()
            }
            progressBar.visibility = View.GONE
            if (result.isSuccessful) {
                val list = result.body()?.result?.data
                newsTitleRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
                newsTitleRecyclerView.adapter = NewsTitleAdapter(this@MainActivity, R.layout.item_title, list)
            }
        }
    }

    override fun getContentView(): Int {
        return R.layout.activity_main
    }

    override fun onDestroy() {
        job.cancel()
        super.onDestroy()
    }

}
