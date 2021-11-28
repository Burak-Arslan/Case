package com.ambluden.myapplication.ui.home

import com.ambluden.core.base.BaseViewModel
import com.ambluden.core.extension.launch
import com.ambluden.myapplication.domain.satellite.SatelliteUseCase
import com.ambluden.myapplication.domain.uimodel.SatelliteUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class FRHomeVM @Inject constructor(private val useCase: SatelliteUseCase) : BaseViewModel() {

    val satelliteList = MutableStateFlow<List<SatelliteUI>?>(null)
    private var satelliteArrayList: List<SatelliteUI>? = null
    private var result = ArrayList<SatelliteUI>()

    fun getSatellite() = launch {
        useCase.getSatellite()
            .onStart { showLoading() }
            .onCompletion { hideLoading() }
            .collect {
                satelliteArrayList = it
                satelliteList.emit(it)
            }
    }

    fun filterList(filter: String?) {
        result = ArrayList()
        satelliteArrayList?.forEach { item ->
            if (item.name!!.contains(filter!!)) {
                result.add(item)
            }
        }
        runBlocking {
            satelliteList.emit(result)
        }
    }
}