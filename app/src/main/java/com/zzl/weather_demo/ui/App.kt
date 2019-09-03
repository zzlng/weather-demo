package com.zzl.weather_demo.ui

import android.app.Application
import com.zzl.weather_demo.extensions.DelegatesExt

class App : Application() {

    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
//        var instance: App by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}