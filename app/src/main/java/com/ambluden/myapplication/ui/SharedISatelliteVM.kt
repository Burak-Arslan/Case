package com.ambluden.myapplication.ui

import android.content.res.Resources
import androidx.lifecycle.SavedStateHandle
import com.ambluden.core.base.BaseViewModel
import com.ambluden.myapplication.domain.uimodel.SatelliteUI
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
open class SharedISatelliteVM @Inject constructor(
    val handle: SavedStateHandle
) : BaseViewModel() {

    var selectedSatellite: SatelliteUI? = null
    var resource: Resources? = null
}
