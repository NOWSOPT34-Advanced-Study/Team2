package org.sopt.now.advanced.team2android.domain.repository

import kotlinx.coroutines.flow.Flow
import org.sopt.now.advanced.team2android.domain.entity.MemberEntity

interface MemberRepository {
    val id: Flow<String>
    val pw: Flow<String>
    val nickname: Flow<String>
    suspend fun saveMemberData(memberEntity: MemberEntity)
}