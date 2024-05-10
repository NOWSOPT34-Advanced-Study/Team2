package com.sopt.now.advanced.team2android.feature.ui.signIn

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.sopt.now.advanced.team2android.feature.databinding.FragmentSignInBinding
import org.sopt.now.advanced.team2android.core.ui.base.BindingFragment

class SignInFragment :
    BindingFragment<FragmentSignInBinding>({ FragmentSignInBinding.inflate(it) }) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSignInBtnClickListener()
        setupSignUpBtnClickListener()
    }

    private fun setupSignInBtnClickListener() {
        binding.btnSignIn.setOnClickListener {
            navigateToHome()
        }
    }

    private fun setupSignUpBtnClickListener() {
        binding.btnSignUp.setOnClickListener {
            navigateToSignUp()
        }
    }


    private fun navigateToHome() {
        Snackbar.make(binding.root, "로그인 버튼 클릭", Snackbar.LENGTH_SHORT).show()
        findNavController().navigate(SignInFragmentDirections.actionSignInToHome())
    }

    private fun navigateToSignUp() {
        Snackbar.make(binding.root, "회원가입 버튼 클릭", Snackbar.LENGTH_SHORT).show()
        findNavController().navigate(SignInFragmentDirections.actionSignInToSignUp())
    }
}