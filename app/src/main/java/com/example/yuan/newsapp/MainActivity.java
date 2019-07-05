package com.example.yuan.newsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<Data> newsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        listView = findViewById(R.id.listView);
        NewsAdapter newsAdapter = new NewsAdapter(this, R.layout.list_item, newsList);
        listView.setAdapter(newsAdapter);
    }
}
