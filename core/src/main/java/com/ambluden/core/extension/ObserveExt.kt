package com.ambluden.core.extension

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

suspend fun MutableStateFlow<Boolean>.emitTrue() = emit(true)

suspend fun MutableStateFlow<Boolean>.emitFalse() = emit(false)

fun <T : Any, L : StateFlow<T?>> LifecycleOwner.collect(liveData: L, body: (T?) -> Unit): Job = this.lifecycleScope.launch {
    liveData.collect { t -> body(t) }
}
