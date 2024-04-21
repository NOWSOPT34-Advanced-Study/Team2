package org.sopt.now.advanced.team2android.domain.repository

import org.sopt.now.advanced.team2android.domain.entity.UserEntity

interface DummyRepository {
    fun getDummyUserList(page: Int = 2): Result<List<UserEntity>>
}