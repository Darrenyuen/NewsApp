package com.yuan.news.adapter

import android.util.Log
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.setPadding
import androidx.recyclerview.widget.RecyclerView
import com.yuan.news.R

/**
 *yuan
 *2020/2/16
 **/
class NewsTypeRecyclerViewAdapter(private val list: Array<String>): RecyclerView.Adapter<NewsTypeRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LinearLayout(parent.context))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val typeName = list[position]
        holder.newsTypeTextView?.text = typeName
    }

    inner class ViewHolder(itemView: LinearLayout): RecyclerView.ViewHolder(itemView) {
        var newsTypeTextView: TextView? = null
        init {
            newsTypeTextView = TextView(itemView.context)
            newsTypeTextView!!.setPadding(20)
            newsTypeTextView!!.textSize = 22F
            itemView.addView(newsTypeTextView)
        }
    }
}