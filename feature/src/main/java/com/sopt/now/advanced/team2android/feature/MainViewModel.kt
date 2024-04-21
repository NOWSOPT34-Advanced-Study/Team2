package com.sopt.now.advanced.team2android.feature

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.sopt.now.advanced.team2android.domain.usecase.GetDummyUserListUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    getDummyUserListUseCase: GetDummyUserListUseCase,
) : ViewModel() {

}