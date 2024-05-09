package com.sopt.now.advanced.team2android.feature.main

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.sopt.now.advanced.team2android.feature.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.now.advanced.team2android.core.ui.base.BindingActivity

@AndroidEntryPoint
class MainActivity : BindingActivity<ActivityMainBinding>({ ActivityMainBinding.inflate(it) }) {
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        testDummyManager()
        observeDummyData()
    }

    private fun testDummyManager() {
        viewModel.putDummyData("Dummy", "default")
    }

    private fun observeDummyData() {
        viewModel.dummy.observe(this) {
            Log.e("DummyTest", it.dummy)
        }
    }
}
