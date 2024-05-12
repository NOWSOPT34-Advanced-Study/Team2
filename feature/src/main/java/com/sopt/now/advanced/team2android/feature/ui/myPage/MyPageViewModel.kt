package com.sopt.now.advanced.team2android.feature.ui.myPage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.sopt.now.advanced.team2android.domain.usecase.GetNicknameUseCase
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(
    private val getNicknameUseCase: GetNicknameUseCase
) : ViewModel() {
    private val _nickname: MutableStateFlow<String?> = MutableStateFlow(null)
    val nickname get() = _nickname.asStateFlow()

    fun fetchNicknameInfo() {
        viewModelScope.launch {
            getNicknameUseCase().collect { nickname ->
                _nickname.value = nickname
            }
        }
    }
}