package com.example.allin1

import android.app.Application
import android.content.Context



class MainApplication : Application() {

    lateinit var mContext : Context

    override fun onCreate() {
        super.onCreate()
        mContext = baseContext
    }

    fun getContext() : Context { return mContext }
}