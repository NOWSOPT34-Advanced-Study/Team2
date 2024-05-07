package com.sopt.now.advanced.team2android.data.di

import com.sopt.now.advanced.team2android.data.dataSource.local.DummyDataSourceImpl
import com.sopt.now.advanced.team2android.data.repository.DummyRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.now.advanced.team2android.domain.repository.DummyRepository
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindsDummyRepository(dummyRepositoryImpl: DummyRepositoryImpl): DummyRepository
}
