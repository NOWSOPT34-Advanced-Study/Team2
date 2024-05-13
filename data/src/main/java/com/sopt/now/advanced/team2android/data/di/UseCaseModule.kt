package com.sopt.now.advanced.team2android.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.now.advanced.team2android.domain.repository.DummyRepository
import org.sopt.now.advanced.team2android.domain.repository.MemberRepository
import org.sopt.now.advanced.team2android.domain.usecase.GetIdUseCase
import org.sopt.now.advanced.team2android.domain.usecase.GetNicknameUseCase
import org.sopt.now.advanced.team2android.domain.usecase.GetPwUseCase
import org.sopt.now.advanced.team2android.domain.usecase.PutDummyDataUseCase
import org.sopt.now.advanced.team2android.domain.usecase.SaveMemberDataUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {
    @Provides
    @Singleton
    fun provideDummyUseCase(dummyRepository: DummyRepository): PutDummyDataUseCase =
        PutDummyDataUseCase(dummyRepository = dummyRepository)

    @Provides
    @Singleton
    fun provideGetIdUseCase(memberRepository: MemberRepository): GetIdUseCase =
        GetIdUseCase(memberRepository = memberRepository)

    @Provides
    @Singleton
    fun provideGetNicknameUseCase(memberRepository: MemberRepository): GetNicknameUseCase =
        GetNicknameUseCase(memberRepository = memberRepository)

    @Provides
    @Singleton
    fun provideGetPwUseCase(memberRepository: MemberRepository): GetPwUseCase =
        GetPwUseCase(memberRepository = memberRepository)

    @Provides
    @Singleton
    fun provideSaveMemberDataUseCase(memberRepository: MemberRepository): SaveMemberDataUseCase =
        SaveMemberDataUseCase(memberRepository = memberRepository)
}
