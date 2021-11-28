package com.ambluden.myapplication.domain.uimodel

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SatelliteDetailUI(
    val id: Int? = null,
    val cost_per_launch: Int? = null,
    val first_flight: String? = null,
    val height: Int? = null,
    val mass: Int? = null
) : Parcelable