package com.example.yuan.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class NewsTitleAdapter extends ArrayAdapter<NewsTitle> {

    private int resourceId;

    public NewsTitleAdapter(Context context, int resource,List<NewsTitle> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NewsTitle newsTitle = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView != null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.title = view.findViewById(R.id.title);
            viewHolder.date = view.findViewById(R.id.date);
            viewHolder.category = view.findViewById(R.id.category);
            viewHolder.author_name = view.findViewById(R.id.author_name);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.title.setText(newsTitle.getTitle());
        viewHolder.date.setText(newsTitle.getDate());
        viewHolder.category.setText(newsTitle.getCategory());
        viewHolder.author_name.setText(newsTitle.getAuthor_name());
        return view;
    }

    class ViewHolder {
        TextView title;
        TextView date;
        TextView category;
        TextView author_name;
    }
}
