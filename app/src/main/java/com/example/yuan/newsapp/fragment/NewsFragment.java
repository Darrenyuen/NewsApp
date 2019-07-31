package com.example.yuan.newsapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuan.newsapp.Bean.News;
import com.example.yuan.newsapp.Bean.NewsBean;
import com.example.yuan.newsapp.NewsContentActivity;
import com.example.yuan.newsapp.NewsTitle;
import com.example.yuan.newsapp.NewsTitleAdapter;
import com.example.yuan.newsapp.R;
import com.example.yuan.newsapp.util.HttpUtil;
import com.example.yuan.newsapp.util.ParseUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class NewsFragment extends Fragment {

    private final String TAG = "NewsFragment";

    private TabLayout tabLayout;
    private ListView listView;
    private SmartRefreshLayout smartRefreshLayout;
    private List<NewsTitle> newsTitleList = new ArrayList<>();
    private NewsTitleAdapter newsTitleAdapter;

    private int[] news_type = new int[]{R.string.top, R.string.guoji, R.string.guonei, R.string.socials, R.string.sports, R.string.military, R.string.technology, R.string.entertainment, R.string.finance, R.string.fashion};


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        newsTitleAdapter = new NewsTitleAdapter(context, R.layout.list_item, newsTitleList);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        tabLayout = view.findViewById(R.id.headNavigation);
        listView = view.findViewById(R.id.listView);
        setHeadNavigation(tabLayout, getLayoutInflater(), news_type);
        initHeadNavigation();
        listView.setAdapter(newsTitleAdapter);
        smartRefreshLayout = view.findViewById(R.id.refreshLayout);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            Intent intent = new Intent(getContext(), NewsContentActivity.class);
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NewsTitle newsTitle = newsTitleList.get(position);
                intent.putExtra("url", newsTitle.getUrl());
                startActivity(intent);
            }
        });
        requestNews();

        return view;
    }

    private void setHeadNavigation(TabLayout tabLayout, LayoutInflater layoutInflater, int[] news_type) {
        for (int i=0; i<news_type.length; i++) {
            TabLayout.Tab tab = tabLayout.newTab();
            View view = layoutInflater.inflate(R.layout.news_navigation_tab, null);
            tab.setCustomView(view);

            TextView textView = view.findViewById(R.id.news_type);
            textView.setText(news_type[i]);
            tabLayout.addTab(tab);
        }
    }

    private void initHeadNavigation() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Toast.makeText(getContext(), tab.getText().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public void requestNews() {
        String url = "http://v.juhe.cn/toutiao/index?type=top&key=c9bafcd7aff837f20267aa453ff843e4";
        HttpUtil.sendOkHttpRequest(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getContext(), "加载失败", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getContext(), "加载成功", Toast.LENGTH_SHORT).show();
                    }
                });
                final String responseText = response.body().string();
                final NewsBean newsBean = ParseUtil.paresJsonWithGson(responseText);
                final String reason = newsBean.reason;
                Log.d(TAG, "onResponse: " + reason);
                if (reason.equals("成功的返回")) {
                    newsTitleList.clear();
                    Log.d(TAG, "onResponse: " + newsBean.error_code + " " + newsBean.reason);
//                    Log.d(TAG, "onResponse: " + newsBean.result.data);
                    Log.d(TAG, "onResponse: " + responseText);
                    for (News news : newsBean.result.data) {
//                        Log.d(TAG, "onResponse: " + news.title);
                        NewsTitle newsTitle = new NewsTitle(news.title, news.date, news.category, news.author_name, news.url);
                        newsTitleList.add(newsTitle);
                    }
                }
            }
        });
    }

}
