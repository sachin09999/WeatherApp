package com.project.weatherzone

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class WeatherApp: Application() {

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG,"Inside Oncreate")
    }

    companion object{
        const val TAG ="Weather app"
    }
}