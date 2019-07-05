package com.example.yuan.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<Data> {
    private int resourceId;
    public NewsAdapter(Context context, int resource, List<Data> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Data data = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.title = (TextView) view.findViewById(R.id.title);
            viewHolder.category = (TextView) view.findViewById(R.id.category);
            viewHolder.author_name = (TextView) view.findViewById(R.id.author_name);
            viewHolder.date = (TextView) view.findViewById(R.id.date);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        return view;
    }
    public class ViewHolder {
        TextView title;
        TextView category;
        TextView author_name;
        TextView date;
    }
}
