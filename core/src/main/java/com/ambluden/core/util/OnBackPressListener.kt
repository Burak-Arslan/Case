package com.ambluden.core.util

interface OnBackPressListener {

    fun isBackEnable():Boolean

    fun onBackPressed():Boolean
}