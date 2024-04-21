package org.sopt.now.advanced.team2android.domain.usecase

import org.sopt.now.advanced.team2android.domain.entity.UserEntity
import org.sopt.now.advanced.team2android.domain.repository.DummyRepository
import javax.inject.Singleton

@Singleton
class GetDummyUserListUseCase(private val dummyRepository: DummyRepository) {
    suspend operator fun invoke(page: Int = 1): Result<List<UserEntity>> =
        dummyRepository.getDummyUserList(page = page)
}