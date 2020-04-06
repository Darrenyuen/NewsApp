package com.yuan.news.base

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class BaseLazyFragment : BaseFragment() {

    private var isDataInitialized: Boolean = false
    private var isViewInitialized: Boolean = false
    private var isVisibleToUser: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getContentView(), container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        isViewInitialized = true
        tryToLoadData()
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        this.isVisibleToUser = isVisibleToUser
        tryToLoadData()
    }

    private fun tryToLoadData() {
        tryToLoadData(false)
    }

    fun tryToLoadData(isForceUpdate: Boolean) {
        Log.d(TAG, "try to load data $isVisibleToUser  $isViewInitialized  $isDataInitialized")
        if (isVisibleToUser && isViewInitialized && (!isDataInitialized || isForceUpdate)) {
            loadData()
        }
    }

    abstract fun loadData()
}
