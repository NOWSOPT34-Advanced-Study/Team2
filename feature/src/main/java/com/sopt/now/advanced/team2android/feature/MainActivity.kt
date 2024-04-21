package com.sopt.now.advanced.team2android.feature

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import com.sopt.now.advanced.team2android.data.implementations.DummyManager
import com.sopt.now.advanced.team2android.data.module.DummyModule
import com.sopt.now.advanced.team2android.feature.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.now.advanced.team2android.core.ui.base.BindingActivity
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.GINGERBREAD)
@AndroidEntryPoint
class MainActivity : BindingActivity<ActivityMainBinding>({ ActivityMainBinding.inflate(it) }) {
    private val viewModel: MainViewModel by viewModels()

    @Inject
    lateinit var dummyManager: DummyManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initDummyManager()
        testDummyManager()
    }

    private fun initDummyManager() {
        dummyManager = DummyModule.provideDummyManager(this)
    }

    private fun testDummyManager() {
        dummyManager.write("testKey", "하위")
        Log.d("MainActivityTest", dummyManager.read("testKey", "None").toString())
    }
}
