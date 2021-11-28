package com.ambluden.core.extension

import androidx.fragment.app.Fragment

fun Fragment.clearCurrentFocus() {
    requireActivity().currentFocus?.clearFocus()
    requireActivity().hideKeyboard()
}