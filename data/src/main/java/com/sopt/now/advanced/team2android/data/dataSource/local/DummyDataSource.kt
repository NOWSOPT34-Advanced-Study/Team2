package com.sopt.now.advanced.team2android.data.dataSource.local

import android.content.SharedPreferences

interface DummyDataSource {
    val sharedPreferences: SharedPreferences
    var dummy: String
}