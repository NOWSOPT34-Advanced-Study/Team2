package org.sopt.now.advanced.team2android.domain.repository

import org.sopt.now.advanced.team2android.domain.entity.DummyEntity
import org.sopt.now.advanced.team2android.domain.entity.MemberEntity

interface DummyRepository {
    fun putDummyData(string: String?, default: String): Result<DummyEntity>
}