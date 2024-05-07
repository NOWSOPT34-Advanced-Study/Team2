package org.sopt.now.advanced.team2android.domain.usecase

import org.sopt.now.advanced.team2android.domain.entity.DummyEntity
import org.sopt.now.advanced.team2android.domain.repository.DummyRepository

class PutDummyDataUseCase(private val dummyRepository: DummyRepository) {
    operator fun invoke(string: String?, default: String): Result<DummyEntity> =
        dummyRepository.putDummyData(string, default)
}