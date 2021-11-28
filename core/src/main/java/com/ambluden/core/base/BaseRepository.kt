package com.ambluden.core.base

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

open class BaseRepository {
    fun <T> sendRequest(req: suspend () -> T): Flow<T> = flow {
        emit(req())
    }
}