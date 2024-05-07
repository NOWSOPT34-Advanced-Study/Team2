package com.sopt.now.advanced.team2android.feature.main

import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.snackbar.Snackbar
import com.sopt.now.advanced.team2android.feature.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.now.advanced.team2android.core.ui.base.BindingActivity

@AndroidEntryPoint
class MainActivity : BindingActivity<ActivityMainBinding>({ ActivityMainBinding.inflate(it) }) {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        testDummyManager()
        observeDummyData()
    }

    private fun testDummyManager() {
        viewModel.putDummyData("test", "default")
    }

    private fun observeDummyData() {
        viewModel.dummy.observe(this) {
            Snackbar.make(binding.root, it, Snackbar.LENGTH_SHORT).show()
        }
    }
}
