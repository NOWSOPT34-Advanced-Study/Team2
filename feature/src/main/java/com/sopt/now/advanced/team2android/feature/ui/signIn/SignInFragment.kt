package com.sopt.now.advanced.team2android.feature.ui.signIn

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.sopt.now.advanced.team2android.feature.R
import com.sopt.now.advanced.team2android.feature.databinding.FragmentSignInBinding
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.now.advanced.team2android.core.ui.base.BindingFragment

@AndroidEntryPoint
class SignInFragment :
    BindingFragment<FragmentSignInBinding>({ FragmentSignInBinding.inflate(it) }) {
    private val viewModel: SignInViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.fetchIdInfo()
        viewModel.fetchPwInfo()
        setupSignInBtnClickListener()
        setupSignUpBtnClickListener()
    }

    private fun setupSignInBtnClickListener() {
        binding.btnSignIn.setOnClickListener {
            signIn()
        }
    }

    private fun setupSignUpBtnClickListener() {
        binding.btnSignUp.setOnClickListener {
            navigateToSignUp()
        }
    }

    private fun signIn() {
        viewModel.signIn(
            id = binding.edtSignInId.text.toString(),
            pw = binding.edtSignInPw.text.toString(),
        ).let { isSignInSuccess ->
            if (isSignInSuccess) {
                Snackbar.make(
                    binding.root,
                    com.sopt.now.advanced.team2android.core.R.string.sign_in_success,
                    Snackbar.LENGTH_SHORT
                ).show()
                navigateToHome()
            }
        }
    }

    private fun navigateToHome() {
        findNavController().navigate(SignInFragmentDirections.actionSignInToHome())
    }

    private fun navigateToSignUp() {
        findNavController().navigate(SignInFragmentDirections.actionSignInToSignUp())
    }
}