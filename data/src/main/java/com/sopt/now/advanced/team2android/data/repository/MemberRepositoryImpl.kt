package com.sopt.now.advanced.team2android.data.repository

import com.sopt.now.advanced.team2android.data.dataSource.local.MemberDataSource
import com.sopt.now.advanced.team2android.data.mapper.toMember
import kotlinx.coroutines.flow.Flow
import org.sopt.now.advanced.team2android.domain.entity.MemberEntity
import org.sopt.now.advanced.team2android.domain.repository.MemberRepository
import javax.inject.Inject

class MemberRepositoryImpl @Inject constructor(private val memberDataSource: MemberDataSource) :
    MemberRepository {
    override val id: Flow<String> = memberDataSource.id

    override val pw: Flow<String> = memberDataSource.pw

    override val nickname: Flow<String> = memberDataSource.nickname

    override suspend fun saveMemberData(memberEntity: MemberEntity) {
        memberDataSource.saveMemberToPreferencesStore(member = memberEntity.toMember())
    }
}