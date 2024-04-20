package org.sopt.now.advenced.team2android.domain.usecase

import org.sopt.now.advenced.team2android.domain.entity.UserEntity
import org.sopt.now.advenced.team2android.domain.repository.DummyRepository

class GetDummyUserListUseCase(private val dummyRepository: DummyRepository) {
    suspend operator fun invoke(page: Int = 2): Result<List<UserEntity>> =
        dummyRepository.getDummyUserList(page = page)
}