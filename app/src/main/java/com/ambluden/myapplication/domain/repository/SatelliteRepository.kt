package com.ambluden.myapplication.domain.repository

import com.ambluden.core.base.BaseRepository
import com.ambluden.core.base.CacheManager
import com.ambluden.myapplication.domain.repository.reqres.PositionResponse
import com.ambluden.myapplication.domain.repository.reqres.SatelliteDetailResponseItem
import com.ambluden.myapplication.domain.repository.reqres.SatelliteResponseItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface SatelliteRepository {
    fun getSatellite(): Flow<List<SatelliteResponseItem>>
    fun getSatelliteDetail(): Flow<List<SatelliteDetailResponseItem>>
}

class SatelliteRepositoryImpl @Inject constructor(
    private val service: SatelliteService,
    val cacheManager: CacheManager
) : BaseRepository(), SatelliteRepository {

    override fun getSatellite() = sendRequest { service.getSatellite() }

    override fun getSatelliteDetail() = sendRequest { service.getSatelliteDetail() }
}
