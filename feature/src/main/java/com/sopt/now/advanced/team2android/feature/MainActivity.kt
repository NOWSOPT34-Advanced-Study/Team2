package com.sopt.now.advanced.team2android.feature

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import com.sopt.now.advanced.team2android.feature.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.now.advanced.team2android.core.ui.base.BindingActivity

@AndroidEntryPoint
class MainActivity : BindingActivity<ActivityMainBinding>({ ActivityMainBinding.inflate(it) }) {
    private val viewModel: MainViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.GINGERBREAD)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DummyManager.write("testKey", "하위")
        val value = DummyManager.read("testKey", "None")
        Log.d("MainActivityTest", value.toString())
    }
}
