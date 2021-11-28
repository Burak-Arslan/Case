package com.ambluden.myapplication.domain.repository.reqres

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize data class SatelliteResponseItem(
    val name: String? = null,
    val active: Boolean? = null,
    val id: Int? = null
) : Parcelable
