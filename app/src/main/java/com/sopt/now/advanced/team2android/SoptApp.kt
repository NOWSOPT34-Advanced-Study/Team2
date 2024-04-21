package com.sopt.now.advanced.team2android

import android.app.Application
import com.sopt.now.advanced.team2android.feature.DummyManager
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SoptApp : Application() {

    override fun onCreate() {
        super.onCreate()

        DummyManager.init(applicationContext)
    }
}