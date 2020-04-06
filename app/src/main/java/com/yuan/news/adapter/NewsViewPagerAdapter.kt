package com.yuan.news.adapter

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.yuan.news.NewsListFragment
import com.yuan.news.main.NewsFragment

/**
 *yuan
 *2020/4/4
 **/
class NewsViewPagerAdapter(fragmentManager: FragmentManager, behavior: Int, stringList: List<String>): FragmentPagerAdapter(fragmentManager, behavior) {

    private var stringList: List<String>? = null

    init {
        this.stringList = stringList
    }

    override fun getItem(position: Int): Fragment {
        return NewsListFragment.newInstance(stringList!![position])
    }

    override fun getCount(): Int {
        return stringList!!.size
    }

    /**
     * top(头条，默认),shehui(社会),guonei(国内),guoji(国际),yule(娱乐),tiyu(体育)junshi(军事),keji(科技),caijing(财经),shishang(时尚)
     */
    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> return "头条"
            1 -> return "社会"
            2 -> return "国内"
            3 -> return "国际"
            4 -> return "娱乐"
            5 -> return "体育"
            6 -> return "军事"
            7 -> return "科技"
            8 -> return "财经"
            9 -> return "时尚"
        }
        return super.getPageTitle(position)
    }
}