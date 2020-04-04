package com.yuan.news

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentPagerAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.yuan.news.adapter.NewsTitleAdapter
import com.yuan.news.adapter.NewsViewPagerAdapter
import com.yuan.news.retrofitApi.GetNews
import kotlinx.android.synthetic.main.fragment_news.*
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * top(头条，默认),shehui(社会),guonei(国内),guoji(国际),yule(娱乐),tiyu(体育),junshi(军事),keji(科技),caijing(财经),shishang(时尚)
 */
class NewsFragment : Fragment() {

    private val TAG = this.javaClass.simpleName

    private var type: String? = null

    companion object{
        fun newInstance(type: String): Fragment {
            val newsFragment = NewsFragment()
            val args = Bundle()
            args.putString("TYPE", type)
            newsFragment.arguments = args
            return newsFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        type = arguments!!.getString("TYPE")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_news, container, false)
        val newsViewPager = view.findViewById<ViewPager>(R.id.newsViewPager)
        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)
        newsViewPager.adapter = NewsViewPagerAdapter(childFragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,
            listOf("top", "shehui", "guonei", "guoji", "yule", "tiyu", "junshi", "keji", "caijing", "shishang"))
        tabLayout.setupWithViewPager(newsViewPager)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://v.juhe.cn/toutiao/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GetNews::class.java)

//        GlobalScope.launch(Dispatchers.Main) {
//            val result = withContext(Dispatchers.IO) {
//                retrofit.getNews(type!!, "c9bafcd7aff837f20267aa453ff843e4").execute()
//            }
//            if (result.isSuccessful) {
//                    val list = result.body()?.result?.data
//                    newsTitleRecyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
//                    newsTitleRecyclerView.adapter =
//                        context?.let { NewsTitleAdapter(it, R.layout.item_title, list) }
//            }
//        }
        return view
    }

}
