package com.sopt.now.advanced.team2android.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.now.advanced.team2android.domain.repository.DummyRepository
import org.sopt.now.advanced.team2android.domain.usecase.PutDummyDataUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Provides
    @Singleton
    fun provideDummyUseCase(dummyRepository: DummyRepository): PutDummyDataUseCase =
        PutDummyDataUseCase(dummyRepository = dummyRepository)
}
