package com.m.phanat.demo

import android.app.Application
import androidx.multidex.MultiDexApplication

open class MainApp : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
    }
}