package com.yuan.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yuan.news.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * top(头条，默认),shehui(社会),guonei(国内),guoji(国际),yule(娱乐),tiyu(体育)junshi(军事),keji(科技),caijing(财经),shishang(时尚)
 */
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, NewsFragment.newInstance("top")).commit()
//        bottomNavigationView.setOnNavigationItemSelectedListener {
//            when(it.itemId) {
//                R.id.newsFragment -> matchFragment(NewsFragment.newInstance("top"))
//                R.id.photoFragment -> matchFragment(PhotoFragment())
//            }
//            true
//        }
    }

    override fun getContentView(): Int {
        return R.layout.activity_main
    }

    private fun matchFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, fragment).commit()
    }

}
