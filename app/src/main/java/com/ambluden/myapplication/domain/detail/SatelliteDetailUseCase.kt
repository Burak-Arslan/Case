package com.ambluden.myapplication.domain.detail

import com.ambluden.core.base.UseCase
import com.ambluden.core.util.Mapper
import com.ambluden.core.util.ResProvider
import com.ambluden.myapplication.domain.repository.SatelliteRepository
import com.ambluden.myapplication.domain.repository.reqres.SatelliteDetailResponseItem
import com.ambluden.myapplication.domain.uimodel.SatelliteDetailUI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SatelliteDetailUseCase @Inject constructor(
    private val resProvider: ResProvider,
    private val repo: SatelliteRepository
) : UseCase<Unit, List<SatelliteDetailUI>>() {

    override fun execute(params: Unit): Flow<List<SatelliteDetailUI>> = flowOf()

     fun getSatelliteDetail(): Flow<List<SatelliteDetailUI>> = repo.getSatelliteDetail().map { response ->
         val items = response?.let { list ->
             list.map { satelliteDetail2UI(it) }
         }
         items
     }

     private fun satelliteDetail2UI(res: SatelliteDetailResponseItem): SatelliteDetailUI {
         return object : Mapper<SatelliteDetailResponseItem, SatelliteDetailUI>() {
             override fun map(value: SatelliteDetailResponseItem): SatelliteDetailUI {
                 with(value) {
                     return SatelliteDetailUI(id, cost_per_launch, first_flight, height, mass)
                 }
             }
         }.map(res)
     }
}