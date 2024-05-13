package com.sopt.now.advanced.team2android.feature.ui.myPage

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.sopt.now.advanced.team2android.feature.databinding.FragmentMyPageBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.sopt.now.advanced.team2android.core.ui.base.BindingFragment

@AndroidEntryPoint
class MyPageFragment :
    BindingFragment<FragmentMyPageBinding>({ FragmentMyPageBinding.inflate(it) }) {
    private val myPageViewModel by viewModels<MyPageViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myPageViewModel.fetchNicknameInfo()
        collectNickname()
    }

    private fun collectNickname() {
        myPageViewModel.nickname.flowWithLifecycle(viewLifecycleOwner.lifecycle)
            .onEach { nickname ->
                binding.tvMyPageNickname.text = nickname
            }.launchIn(viewLifecycleOwner.lifecycleScope)
    }
}