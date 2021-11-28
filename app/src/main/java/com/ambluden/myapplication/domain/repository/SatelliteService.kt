package com.ambluden.myapplication.domain.repository

import com.ambluden.myapplication.domain.repository.reqres.SatelliteDetailResponseItem
import com.ambluden.myapplication.domain.repository.reqres.SatelliteResponseItem
import retrofit2.http.POST

interface SatelliteService {

    @POST("satellite/v1")
    suspend fun getSatellite(): List<SatelliteResponseItem>

    @POST("satellite/detail/v1")
    suspend fun getSatelliteDetail(): List<SatelliteDetailResponseItem>
}
