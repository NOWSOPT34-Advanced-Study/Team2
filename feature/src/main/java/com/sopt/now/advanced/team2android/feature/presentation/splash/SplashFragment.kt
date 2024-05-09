package com.sopt.now.advanced.team2android.feature.presentation.splash

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.sopt.now.advanced.team2android.feature.databinding.FragmentSplashBinding
import org.sopt.now.advanced.team2android.core.ui.base.BindingFragment

class SplashFragment :
    BindingFragment<FragmentSplashBinding>({ FragmentSplashBinding.inflate(it) }) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        findNavController().navigate(SplashFragmentDirections.actionSplashToSignIn())
    }
}