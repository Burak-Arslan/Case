package com.ambluden.myapplication.domain.uimodel

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SatelliteDetailPosition(
    val list: List<SatelliteDetailPositionUI?>?
) : Parcelable

@Parcelize
data class SatelliteDetailPositionUI(
    val positions: List<PositionsItemUI?>,
    val id: String? = null
) : Parcelable


@Parcelize
data class PositionsItemUI(
    val posX: Double? = null,
    val posY: Double? = null
) : Parcelable