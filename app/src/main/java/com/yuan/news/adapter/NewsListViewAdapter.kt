package com.yuan.news.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.yuan.news.R
import com.yuan.news.bean.DataBean
import com.yuan.news.bean.NewsResult

/**
 *yuan
 *2020/1/30
 **/
class NewsListViewAdapter(context: Context, resource: Int, list: ArrayList<DataBean>?): ArrayAdapter<DataBean>(context, resource,
    list!!
) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_title, parent, false)
            viewHolder = ViewHolder()
            viewHolder.titleTextView = view.findViewById(R.id.newsTitleTextView) as TextView
            viewHolder.sourceTextView = view.findViewById(R.id.sourceTextView)
            viewHolder.dateTextView = view.findViewById(R.id.dateTextView)
            viewHolder.typeTextView = view.findViewById(R.id.typeTextView)
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        viewHolder.titleTextView!!.text =
        return view
    }

    inner class ViewHolder {
        var titleTextView: TextView? = null
        var sourceTextView: TextView? = null
        var dateTextView: TextView? = null
        var typeTextView: TextView? = null
    }
}