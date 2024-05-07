package com.sopt.now.advanced.team2android.feature.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.sopt.now.advanced.team2android.domain.entity.DummyEntity
import org.sopt.now.advanced.team2android.domain.repository.DummyRepository
import org.sopt.now.advanced.team2android.domain.usecase.PutDummyDataUseCase
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val putDummyDataUseCase: PutDummyDataUseCase
) : ViewModel() {

    private val _dummy = MutableLiveData<String>()
    val dummy: LiveData<String> get() = _dummy

    fun putDummyData(string: String?, default: String) {
        putDummyDataUseCase(string, default).onSuccess {
            _dummy.postValue(it.dummy)
        }
    }
}