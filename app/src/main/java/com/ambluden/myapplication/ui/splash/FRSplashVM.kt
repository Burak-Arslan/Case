package com.ambluden.myapplication.ui.splash

import com.ambluden.core.base.BaseViewModel
import com.ambluden.core.extension.launch
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class FRSplashVM @Inject constructor() : BaseViewModel() {

    var navigationNext = MutableStateFlow(false)

    companion object {
        var splashDisplayDuration = 500L
    }

    fun initVM() {
        launch {
            delay(splashDisplayDuration)
            navigationNext.emit(true)
        }
    }
}