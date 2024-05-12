package com.sopt.now.advanced.team2android.feature.ui.signUp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.sopt.now.advanced.team2android.feature.R
import com.sopt.now.advanced.team2android.feature.databinding.FragmentSignUpBinding
import dagger.hilt.android.AndroidEntryPoint
import org.sopt.now.advanced.team2android.core.ui.base.BindingFragment
import org.sopt.now.advanced.team2android.domain.entity.MemberEntity

@AndroidEntryPoint
class SignUpFragment :
    BindingFragment<FragmentSignUpBinding>({ FragmentSignUpBinding.inflate(it) }) {
    private val signUpViewModel by viewModels<SignUpViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setSignUpBtnClickListeners()
    }

    private fun setSignUpBtnClickListeners() {
        with(binding) {
            btnSignUp.setOnClickListener {
                MemberEntity(
                    id = etSignUpId.editText.text.toString(),
                    pw = etSignUpPassword.editText.text.toString(),
                    nickname = etSignUpNickname.editText.text.toString()
                ).let { memberEntity ->
                    signUpViewModel.signUp(memberEntity = memberEntity)
                    navigateToSignIn()
                }
            }
        }
    }

    private fun navigateToSignIn() {
        findNavController().navigate(R.id.action_sign_up_to_sign_in)
    }
}