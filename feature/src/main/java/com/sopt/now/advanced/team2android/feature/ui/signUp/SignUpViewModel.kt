package com.sopt.now.advanced.team2android.feature.ui.signUp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.sopt.now.advanced.team2android.domain.entity.MemberEntity
import org.sopt.now.advanced.team2android.domain.usecase.SaveMemberDataUseCase
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val saveMemberDataUseCase: SaveMemberDataUseCase
) : ViewModel() {
    fun signUp(memberEntity: MemberEntity) {
        viewModelScope.launch {
            saveMemberDataUseCase(memberEntity = memberEntity)
        }
    }
}