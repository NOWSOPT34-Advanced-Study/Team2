package org.sopt.now.advenced.team2android.domain.repository

import org.sopt.now.advenced.team2android.domain.entity.UserEntity

interface DummyRepository {
    suspend fun getDummyUserList(page: Int = 2): Result<List<UserEntity>>
}