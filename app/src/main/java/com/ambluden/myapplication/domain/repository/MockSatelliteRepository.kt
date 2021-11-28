package com.ambluden.myapplication.domain.repository

import android.content.Context
import com.ambluden.core.base.BaseRepository
import com.ambluden.core.base.CacheManager
import com.ambluden.core.extension.getJson
import com.ambluden.myapplication.R
import com.ambluden.myapplication.domain.repository.reqres.SatelliteDetailResponseItem
import com.ambluden.myapplication.domain.repository.reqres.SatelliteResponseItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow

class MockSatelliteRepository(val context: Context, var cacheManager: CacheManager) :
    BaseRepository(),
    SatelliteRepository {

    override fun getSatellite(): Flow<List<SatelliteResponseItem>> = sendRequest {
        delay(640)
        context.getJson(file = R.raw.satellite)
    }

    override fun getSatelliteDetail(): Flow<List<SatelliteDetailResponseItem>> = sendRequest {
        delay(640)
        context.getJson(file = R.raw.satellite_detail)
    }
}

