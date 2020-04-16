package com.yuan.news.widget.pulltorefreshandload;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * yuan
 * 2020/4/16
 **/
public class PullableListView extends ListView implements Pullable {
    public PullableListView(Context context) {
        super(context);
    }

    public PullableListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PullableListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean canPullDown() {
        if (getCount() == 0) {
            return true;
        } else return getFirstVisiblePosition() == 0 && getChildAt(0).getTop() >= 0;
    }

    @Override
    public boolean canPullUp() {
        //没有item时也可以上拉加载
        if (getCount() == 0) return true;
        else if (getLastVisiblePosition() == (getCount() - 1)) {
            return (getChildAt(getLastVisiblePosition() - getFirstVisiblePosition()) != null
                    && getChildAt(getLastVisiblePosition() - getFirstVisiblePosition()).getBottom() <= getMeasuredHeight());
        }
        return false;
    }
}
