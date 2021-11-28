package com.ambluden.core.extension;

import com.ambluden.core.util.GsonProvider
import com.google.gson.reflect.TypeToken

inline fun <reified T> String.toModel(): T = GsonProvider.gson.fromJson(this, object : TypeToken<T>() {}.type)
