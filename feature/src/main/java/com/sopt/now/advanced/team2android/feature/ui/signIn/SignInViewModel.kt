package com.sopt.now.advanced.team2android.feature.ui.signIn

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.sopt.now.advanced.team2android.domain.entity.DummyEntity
import org.sopt.now.advanced.team2android.domain.entity.MemberEntity
import org.sopt.now.advanced.team2android.domain.usecase.GetSignInMemberDataUseCase
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val getSignInMemberDataUseCase: GetSignInMemberDataUseCase,
) : ViewModel() {
    private val _dummy = MutableLiveData<MemberEntity>(MemberEntity("", ""))
    val dummy: LiveData<MemberEntity> get() = _dummy

    fun getSignInMemberData(id: String, pw: String) {
        getSignInMemberDataUseCase(id, pw).onSuccess {
            _dummy.postValue(it)
        }
    }
}