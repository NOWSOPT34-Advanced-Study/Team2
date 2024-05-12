package com.sopt.now.advanced.team2android.data.repository

import android.util.Log
import com.sopt.now.advanced.team2android.data.dataSource.local.MemberDataSource
import org.sopt.now.advanced.team2android.domain.entity.MemberEntity
import org.sopt.now.advanced.team2android.domain.repository.MemberRepository
import javax.inject.Inject

class MemberRepositoryImpl @Inject constructor(private val memberDataSource: MemberDataSource) :
    MemberRepository {
    override fun getSignInMemberData(id: String, pw: String): Result<MemberEntity> {
        memberDataSource.id = id
        memberDataSource.pw = pw
        return Result.success(MemberEntity(memberDataSource.id, memberDataSource.pw))
    }
}