package com.example.yuan.newsapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.yuan.newsapp.fragment.NewsFragment;
import com.example.yuan.newsapp.fragment.PersonalFragment;
import com.example.yuan.newsapp.fragment.PhotoWallFragment;

/**
 * 主界面底部菜单栏适配器
 */
public class MainFragmentAdapter extends FragmentPagerAdapter {

    public MainFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = null;
        switch (i) {
            case 0:
                fragment = new NewsFragment();
                break;
            case 1:
                fragment = new PhotoWallFragment();
                break;
            case 2:
                fragment = new PersonalFragment();
                break;
            default:
                    break;
        }
        return fragment;
    }
}
