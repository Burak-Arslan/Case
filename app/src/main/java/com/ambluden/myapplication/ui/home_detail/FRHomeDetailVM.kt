package com.ambluden.myapplication.ui.home_detail

import android.content.res.Resources
import androidx.lifecycle.MutableLiveData
import com.ambluden.core.base.BaseViewModel
import com.ambluden.core.extension.launch
import com.ambluden.core.util.SingleLiveEvent
import com.ambluden.myapplication.R
import com.ambluden.myapplication.domain.detail.SatelliteDetailUseCase
import com.ambluden.myapplication.domain.repository.reqres.PositionResponse
import com.ambluden.myapplication.domain.uimodel.SatelliteDetailUI
import com.ambluden.myapplication.domain.uimodel.SatelliteUI
import com.beust.klaxon.Klaxon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class FRHomeDetailVM @Inject constructor(
    private val satelliteDetailUseCase: SatelliteDetailUseCase
) : BaseViewModel() {

    var resources: Resources? = null
    var selectedSatellite: SatelliteUI? = null
    val satelliteDetailList = MutableStateFlow<List<SatelliteDetailUI>?>(null)
    var positionList: PositionResponse? = null
    var satelliteName = MutableLiveData<String>()
    var satelliteDate = SingleLiveEvent("")
    var satelliteHeightMass = SingleLiveEvent("")
    var satelliteCost = SingleLiveEvent("")
    var satelliteLastPosition = SingleLiveEvent("")

    fun getSatelliteDetailPosition() = launch {
        satelliteDetailUseCase.getSatelliteDetail()
            .onStart { showLoading() }
            .onCompletion { hideLoading() }
            .collect {
                satelliteDetailList?.emit(it)
            }
    }

    fun getPosition(resources: Resources): PositionResponse? {
        positionList = PositionResponse()
        val json = resources.openRawResource(R.raw.position).bufferedReader().use { it.readText() }
        val klaxon = Klaxon()
        positionList = klaxon.parse<PositionResponse>(json)
        return positionList
    }
}