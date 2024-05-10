package org.sopt.now.advanced.team2android.domain.repository

import org.sopt.now.advanced.team2android.domain.entity.DummyEntity

interface DummyRepository {
    fun putDummyData(string: String?, default: String): Result<DummyEntity>
}