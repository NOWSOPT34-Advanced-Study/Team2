package com.sopt.now.advanced.team2android.data.di

import com.sopt.now.advanced.team2android.data.dataSource.local.DummyDataSource
import com.sopt.now.advanced.team2android.data.dataSource.local.DummyDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    @Singleton
    abstract fun bindsDummyDataSource(dummyDataSourceImpl: DummyDataSourceImpl): DummyDataSource
}
