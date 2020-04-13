package com.yuan.news

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.LruCache
import kotlin.math.roundToInt

/**
 *yuan
 *2020/4/13
 **/
class ImageLoader {

    companion object{
        var mMemoryCache: LruCache<String, Bitmap>? = null
        var imageLoader: ImageLoader? = null

        fun getInstance(): ImageLoader{
            if (imageLoader == null) {
                synchronized(ImageLoader::class.java) {
                    if (imageLoader == null) {
                        imageLoader = ImageLoader()
                    }
                    return imageLoader!!
                }
            }
            return imageLoader!!
        }

        //计算压缩比
        private fun calculateInSampleSize(options: BitmapFactory.Options, reqWidth: Int) : Int {
            val width = options.outWidth
            var inSampleSize = 1
            if (width > reqWidth) {
                inSampleSize = (width as Float / reqWidth).roundToInt()
            }
            return inSampleSize
        }

        //读取图片
        fun decodeSampledBitmapFromResource(pathName: String, reqWidth: Int): Bitmap {
            val options = BitmapFactory.Options()
            options.inJustDecodeBounds = true
            BitmapFactory.decodeFile(pathName, options)
            options.inSampleSize = calculateInSampleSize(options, reqWidth)
            options.inJustDecodeBounds = false
            return BitmapFactory.decodeFile(pathName, options)
        }
    }

    init {
        val maxMemory = Runtime.getRuntime().maxMemory() as Int
        val cacheSize = maxMemory / 8
        mMemoryCache = object : LruCache<String, Bitmap>(cacheSize) {
            override fun sizeOf(key: String?, value: Bitmap?): Int {
                return value!!.byteCount
            }
        }
    }

    fun addBitmapToMemoryCache(key: String, bitmap: Bitmap) {
        if (getBitmapFromMemoryCache(key) == null) mMemoryCache!!.put(key, bitmap)
    }

    fun getBitmapFromMemoryCache(key: String) : Bitmap? {
        return mMemoryCache!!.get(key)
    }


}