package com.yuan.news.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yuan.news.R
import com.yuan.news.base.BaseActivity

/**
 * top(头条，默认),shehui(社会),guonei(国内),guoji(国际),yule(娱乐),tiyu(体育)junshi(军事),keji(科技),caijing(财经),shishang(时尚)
 */
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        matchFragment(NewsFragment())
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.newsFragment -> matchFragment(NewsFragment())
                R.id.photoFragment -> matchFragment(PhotoFragment())
            }
            true
        }
    }

    override fun getContentView(): Int {
        return R.layout.activity_main
    }

    private fun matchFragment(fragment: Fragment) {
        Log.d(TAG, "new fragment")
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, fragment).commit()
    }

}
