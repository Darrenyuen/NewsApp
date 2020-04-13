package com.yuan.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import com.yuan.news.base.BaseActivity
import kotlinx.android.synthetic.main.activity_news_content.*

class NewsContentActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val url = intent.getStringExtra("URL")
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()
        webView.webChromeClient = object : WebChromeClient() {
            override fun onProgressChanged(view: WebView?, newProgress: Int) {
                if (newProgress == 100) progressBar.visibility = View.GONE
                else {
                    progressBar.visibility = View.VISIBLE
                    progressBar.progress = newProgress
                }
                super.onProgressChanged(view, newProgress)
            }
        }
        webView.loadUrl(url)
    }

    override fun getContentView(): Int {
        return R.layout.activity_news_content
    }
}
