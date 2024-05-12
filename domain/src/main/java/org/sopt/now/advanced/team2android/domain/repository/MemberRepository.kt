package org.sopt.now.advanced.team2android.domain.repository

import org.sopt.now.advanced.team2android.domain.entity.MemberEntity

interface MemberRepository {
    fun getSignInMemberData(id: String, pw: String): Result<MemberEntity>
}