package com.yuan.news

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.yuan.news.adapter.NewsTitleAdapter
import com.yuan.news.base.BaseLazyFragment
import com.yuan.news.bean.NewsData
import com.yuan.news.bean.NewsResult
import com.yuan.news.retrofitApi.GetNews
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsListFragment : BaseLazyFragment() {

    private var newsType: String? = null
    private var listView: ListView? = null
    private var newsTitleAdapter: NewsTitleAdapter? = null
    private var swipeRefreshLayout: SwipeRefreshLayout? = null

    companion object {
        fun newInstance(type: String): Fragment {
            val newsListFragment = NewsListFragment()
            val bundle = Bundle()
            bundle.putString("TYPE", type)
            newsListFragment.arguments = bundle
            return newsListFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val argument = arguments
        newsType = argument!!.getString("TYPE")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(getContentView(), container, false)
        listView = view.findViewById(R.id.listView)
        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout)
        swipeRefreshLayout!!.setOnRefreshListener {
            tryToLoadData(true)
        }
        return view
    }

    override fun getContentView(): Int {
        return R.layout.fragment_news_list
    }

    override fun loadData() {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://v.juhe.cn/toutiao/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GetNews::class.java)

        GlobalScope.launch(Dispatchers.Main) {
            val result = withContext(Dispatchers.IO) {
                retrofit.getNews(newsType!!, "c9bafcd7aff837f20267aa453ff843e4").execute()
            }
            if (result.isSuccessful) {
                swipeRefreshLayout!!.isRefreshing = false
                newsTitleAdapter = NewsTitleAdapter(context!!, R.layout.item_title, result.body()!!.result.data)
                listView!!.adapter = newsTitleAdapter
            }
        }
    }

}
