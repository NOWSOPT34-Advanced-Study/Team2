package com.sopt.now.advanced.team2android.data.dataSource.local

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class DummyDataSourceImpl @Inject constructor(@ApplicationContext context: Context) :
    DummyDataSource {

    private val pref: SharedPreferences =
        context.getSharedPreferences(DUMMY_KEY, Context.MODE_PRIVATE)

    override val sharedPreferences: SharedPreferences
        get() = pref

    override var dummy: String
        get() = pref.getString(DUMMY_KEY, "") ?: ""
        set(value) = pref.edit { putString(DUMMY_KEY, value) }


    companion object {
        private const val DUMMY_KEY = "Dummy"
    }
}
