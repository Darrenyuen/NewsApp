package com.yuan.news.widget.pulltorefreshandload;

/**
 * yuan
 * 2020/4/16
 **/
public interface Pullable {
    /**
     *
     * @return true 表示可以下拉
     */
    boolean canPullDown();

    boolean canPullUp();
}
