package com.ambluden.core.util

import android.content.Intent

data class FinishActivityWithResult(
    var resultCode: Int,
    var data: Intent?
)