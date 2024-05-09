package com.sopt.now.advanced.team2android.feature.presentation.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import com.sopt.now.advanced.team2android.feature.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.now.advanced.team2android.core.ui.base.BindingFragment

@AndroidEntryPoint
class HomeFragment : BindingFragment<FragmentHomeBinding>({ FragmentHomeBinding.inflate(it) }) {
    private val viewModel by viewModels<HomeViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        testDummyManager()
        observeDummyData()
    }

    private fun testDummyManager() {
        viewModel.putDummyData("Dummy", "default")
    }

    private fun observeDummyData() {
        viewModel.dummy.observe(viewLifecycleOwner) {
            Log.e("DummyTest", it.dummy)
        }
    }
}