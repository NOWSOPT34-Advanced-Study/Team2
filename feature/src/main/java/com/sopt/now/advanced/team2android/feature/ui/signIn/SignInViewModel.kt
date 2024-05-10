package com.sopt.now.advanced.team2android.feature.ui.signIn

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.sopt.now.advanced.team2android.domain.entity.MemberEntity
import org.sopt.now.advanced.team2android.domain.usecase.GetSignInMemberDataUseCase
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val getSignInMemberDataUseCase: GetSignInMemberDataUseCase,
) : ViewModel() {
    private val _member = MutableLiveData(MemberEntity("", ""))
    val member: LiveData<MemberEntity> get() = _member

    fun getSignInMemberData(id: String, pw: String) {
        getSignInMemberDataUseCase(id, pw).onSuccess {
            _member.postValue(it)
        }
    }
}