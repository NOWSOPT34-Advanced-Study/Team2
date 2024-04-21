package com.sopt.now.advanced.team2android.data.implementations

import com.sopt.now.advanced.team2android.data.module.DummyService
import org.sopt.now.advanced.team2android.domain.entity.UserEntity
import org.sopt.now.advanced.team2android.domain.repository.DummyRepository
import javax.inject.Inject

class DummyRepositoryImpl @Inject constructor(
    private val dummyService: DummyService
) : DummyRepository {
    override fun getDummyUserList(page: Int): Result<List<UserEntity>> {
        TODO("Not yet implemented")
    }
}