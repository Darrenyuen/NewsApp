package com.yuan.news.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.yuan.news.R
import com.yuan.news.bean.DataBean
import com.yuan.news.bean.NewsResult
import kotlinx.android.synthetic.main.item_title.view.*
import org.w3c.dom.Text

/**
 *yuan
 *2020/4/6
 **/
class NewsTitleAdapter(context: Context, resource: Int, objects: List<NewsResult.ResultBean.DataBean>): ArrayAdapter<NewsResult.ResultBean.DataBean>(context, resource, objects) {

    var resourceId: Int? = null
    var newsTitleList: List<NewsResult.ResultBean.DataBean>? = null

    init {
        resourceId = resource
        newsTitleList = objects
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val dataBean = newsTitleList!![position]
        var viewHolder: ViewHolder?
        var view: View?
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(resourceId!!, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        viewHolder.title!!.text = dataBean.title
        viewHolder.source!!.text = dataBean.category
        viewHolder.date!!.text = dataBean.date
        return view!!
    }

    inner class ViewHolder(view: View) {
        var title: TextView? = null
        var source: TextView? = null
        var date: TextView? = null

        init {
            title = view.findViewById(R.id.newsTitleTextView)
            source = view.findViewById(R.id.sourceTextView)
            date = view.findViewById(R.id.dateTextView)
        }
    }
}