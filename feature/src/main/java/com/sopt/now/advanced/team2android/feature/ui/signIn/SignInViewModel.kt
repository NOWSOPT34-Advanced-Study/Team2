package com.sopt.now.advanced.team2android.feature.ui.signIn

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.sopt.now.advanced.team2android.domain.usecase.GetIdUseCase
import org.sopt.now.advanced.team2android.domain.usecase.GetPwUseCase
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val getIdUseCase: GetIdUseCase,
    private val getPwUseCase: GetPwUseCase
) : ViewModel() {
    private val _id: MutableStateFlow<String?> = MutableStateFlow(null)
    private val _pw: MutableStateFlow<String?> = MutableStateFlow(null)

    fun fetchIdInfo() {
        viewModelScope.launch {
            getIdUseCase().collect { id ->
                _id.value = id
            }
        }
    }

    fun fetchPwInfo() {
        viewModelScope.launch {
            getPwUseCase().collect { pw ->
                _pw.value = pw
            }
        }
    }

    fun signIn(id: String, pw: String): Boolean = _id.value == id && _pw.value == pw
}