package com.yuan.news.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.yuan.news.R
import com.yuan.news.adapter.NewsViewPagerAdapter
import com.yuan.news.base.BaseFragment
import com.yuan.news.retrofitApi.GetNews
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * top(头条，默认),shehui(社会),guonei(国内),guoji(国际),yule(娱乐),tiyu(体育),junshi(军事),keji(科技),caijing(财经),shishang(时尚)
 */
class NewsFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        val newsViewPager = view!!.findViewById<ViewPager>(R.id.newsViewPager)
        val tabLayout = view.findViewById<TabLayout>(R.id.tabLayout)
        newsViewPager!!.adapter = NewsViewPagerAdapter(childFragmentManager, FragmentPagerAdapter.BEHAVIOR_SET_USER_VISIBLE_HINT,
            listOf("top", "shehui", "guonei", "guoji", "yule", "tiyu", "junshi", "keji", "caijing", "shishang")) //选择BEHAVIOR_SET_USER_VISIBLE_HINT fragment才会调用setVisibleToUser(isVisibleToUser)
        tabLayout?.setupWithViewPager(newsViewPager)
        newsViewPager.currentItem = 0
        return view
    }

    override fun getContentView(): Int {
        return R.layout.fragment_news
    }
}
