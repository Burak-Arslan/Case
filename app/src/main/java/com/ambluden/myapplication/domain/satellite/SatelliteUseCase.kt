package com.ambluden.myapplication.domain.satellite

import com.ambluden.core.base.UseCase
import com.ambluden.core.util.Mapper
import com.ambluden.core.util.ResProvider
import com.ambluden.myapplication.domain.repository.SatelliteRepository
import com.ambluden.myapplication.domain.repository.reqres.SatelliteResponseItem
import com.ambluden.myapplication.domain.uimodel.SatelliteUI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SatelliteUseCase @Inject constructor(
    private val resProvider: ResProvider,
    private val repo: SatelliteRepository
) : UseCase<Unit, List<SatelliteUI>>() {

     fun getSatellite(): Flow<List<SatelliteUI>> = repo.getSatellite().map { response ->
         val items = response?.let { list ->
             list.map { satellite2UI(it) }
         }
         items
     }

     private fun satellite2UI(res: SatelliteResponseItem): SatelliteUI {
         return object : Mapper<SatelliteResponseItem, SatelliteUI>() {
             override fun map(value: SatelliteResponseItem): SatelliteUI {
                 with(value) {
                     return SatelliteUI(name, active, id)
                 }
             }
         }.map(res)
     }

    override fun execute(params: Unit): Flow<List<SatelliteUI>> = flowOf()
}
