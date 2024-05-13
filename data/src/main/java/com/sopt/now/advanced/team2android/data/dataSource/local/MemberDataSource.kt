package com.sopt.now.advanced.team2android.data.dataSource.local

import com.sopt.now.advanced.team2android.data.model.Member
import kotlinx.coroutines.flow.Flow

interface MemberDataSource {
    var id: Flow<String>
    var pw: Flow<String>
    var nickname: Flow<String>
    suspend fun saveMemberToPreferencesStore(member: Member)
}