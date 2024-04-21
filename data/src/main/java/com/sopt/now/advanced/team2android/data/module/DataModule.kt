package com.sopt.now.advanced.team2android.data.module

import com.sopt.now.advanced.team2android.data.implementations.DummyRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.now.advanced.team2android.domain.entity.UserEntity
import org.sopt.now.advanced.team2android.domain.repository.DummyRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

}

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindDummyRepository(dummyRepositoryImpl: DummyRepositoryImpl) : DummyRepository
}

interface DummyService {
    suspend fun getDummyUserList(page: Int): List<UserEntity>
}