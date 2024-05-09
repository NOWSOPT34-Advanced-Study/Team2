package com.sopt.now.advanced.team2android.data.repository

import com.sopt.now.advanced.team2android.data.dataSource.local.DummyDataSource
import org.sopt.now.advanced.team2android.domain.entity.DummyEntity
import org.sopt.now.advanced.team2android.domain.repository.DummyRepository
import javax.inject.Inject

class DummyRepositoryImpl @Inject constructor(private val dummyDataSource: DummyDataSource) :
    DummyRepository {
    override fun putDummyData(string: String?, default: String): Result<DummyEntity> {
        dummyDataSource.dummy = string ?: default
        return Result.success(DummyEntity(dummyDataSource.dummy))
    }
}