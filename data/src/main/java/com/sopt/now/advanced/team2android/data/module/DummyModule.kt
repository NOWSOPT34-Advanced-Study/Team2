package com.sopt.now.advanced.team2android.data.module

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.sopt.now.advanced.team2android.data.implementations.DummyManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@RequiresApi(Build.VERSION_CODES.GINGERBREAD)
@Module
@InstallIn(SingletonComponent::class)
object DummyModule {
    @Singleton
    @Provides
    fun provideDummyManager(@ApplicationContext context: Context): DummyManager {
        return DummyManager.apply {
            init(context)
        }
    }
}