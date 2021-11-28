package com.ambluden.myapplication.di

import android.content.Context
import com.ambluden.core.base.CacheManager
import com.ambluden.myapplication.domain.repository.SatelliteRepository
import com.ambluden.myapplication.domain.repository.MockSatelliteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Satellite {

    @Singleton
    @Provides
    fun provideSatelliteRepository(@ApplicationContext context: Context, cacheManager: CacheManager): SatelliteRepository = MockSatelliteRepository(context, cacheManager)
}
