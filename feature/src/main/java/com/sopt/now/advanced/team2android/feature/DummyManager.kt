package com.sopt.now.advanced.team2android.feature

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.GINGERBREAD)
object DummyManager {

    private var sharedPreferences: SharedPreferences? = null

    fun init(context: Context) {
        if (sharedPreferences == null) sharedPreferences =
            context.getSharedPreferences("TEST_PREFERENCE", Activity.MODE_PRIVATE)
    }

    // String
    fun read(key: String?, defValue: String?): String? {
        return sharedPreferences!!.getString(key, defValue)
    }

    fun write(key: String?, value: String?) {
        val prefsEditor = sharedPreferences!!.edit()
        prefsEditor.putString(key, value)
        prefsEditor.apply()
    }


    // Boolean
    fun read(key: String?, defValue: Boolean): Boolean {
        return sharedPreferences!!.getBoolean(key, defValue)
    }

    fun write(key: String?, value: Boolean) {
        val prefsEditor = sharedPreferences!!.edit()
        prefsEditor.putBoolean(key, value)
        prefsEditor.apply()
    }


    // Int
    fun read(key: String?, defValue: Int): Int {
        return sharedPreferences!!.getInt(key, defValue)
    }

    fun write(key: String?, value: Int?) {
        val prefsEditor = sharedPreferences!!.edit()
        prefsEditor.putInt(key, value!!).apply()
    }
}