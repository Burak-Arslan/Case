package com.ambluden.myapplication.domain.uimodel

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SatelliteUI(
    val name: String? = null,
    val active: Boolean? = null,
    val id: Int? = null
) : Parcelable
