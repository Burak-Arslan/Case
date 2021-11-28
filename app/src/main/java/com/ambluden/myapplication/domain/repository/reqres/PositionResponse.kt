package com.ambluden.myapplication.domain.repository.reqres

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PositionResponse(
	val list: List<ListItemPosition?>? = null
):Parcelable

@Parcelize
data class ListItemPosition(
	val positions: List<PositionsItem?>? = null,
	val id: String? = null
):Parcelable

@Parcelize
data class PositionsItem(
	val posX: Double? = null,
	val posY: Double? = null
):Parcelable
