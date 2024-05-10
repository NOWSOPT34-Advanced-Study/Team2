package com.sopt.now.advanced.team2android.feature.ui.signIn

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.sopt.now.advanced.team2android.feature.databinding.FragmentSignInBinding
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.now.advanced.team2android.core.ui.base.BindingFragment

@AndroidEntryPoint
class SignInFragment :
    BindingFragment<FragmentSignInBinding>({ FragmentSignInBinding.inflate(it) }) {

    private val viewModel: SignInViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSignInBtnClickListener()
        setupSignUpBtnClickListener()
    }

    private fun setupSignInBtnClickListener() {
        binding.btnSignIn.setOnClickListener {
            getMemberPreferences()
            navigateToHome()
        }
    }

    private fun setupSignUpBtnClickListener() {
        binding.btnSignUp.setOnClickListener {
            navigateToSignUp()
        }
    }

    private fun getMemberPreferences() {
        viewModel.getSignInMemberData(
            binding.edtSignInId.text.toString(),
            binding.edtSignInPw.text.toString(),
        )
        viewModel.member.observe(viewLifecycleOwner) { data ->
            Snackbar.make(binding.root, "아이디: ${data.id}, 비밀번호: ${data.pw}", Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun navigateToHome() {
        findNavController().navigate(SignInFragmentDirections.actionSignInToHome())
    }

    private fun navigateToSignUp() {
        Snackbar.make(binding.root, "회원가입 버튼 클릭", Snackbar.LENGTH_SHORT).show()
        findNavController().navigate(SignInFragmentDirections.actionSignInToSignUp())
    }
}