package com.yuan.news.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yuan.news.R
import com.yuan.news.bean.Data

/**
 *yuan
 *2020/2/17
 **/
class NewsTitleAdapter(private val context: Context, private val resourceId: Int, private val list: List<Data>?): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(resourceId, parent, false))
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder =  holder as ViewHolder
        val data = list!![position]
        viewHolder.titleTextView!!.text = data.title
        viewHolder.sourceTextView!!.text = data.author_name
        viewHolder.dateTextView!!.text = data.date
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleTextView: TextView? = null
        var sourceTextView: TextView? = null
        var dateTextView: TextView? = null
        init {
            titleTextView = itemView.findViewById(R.id.newsTitleTextView)
            sourceTextView = itemView.findViewById(R.id.sourceTextView)
            dateTextView = itemView.findViewById(R.id.dateTextView)
        }
    }
}