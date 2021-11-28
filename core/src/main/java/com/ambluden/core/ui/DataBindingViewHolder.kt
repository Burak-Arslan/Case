package com.ambluden.core.ui

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.ambluden.core.BR

open class DataBindingViewHolder<T>(val binding: ViewDataBinding, private val currentSelected: T? = null) :
    RecyclerView.ViewHolder(binding.root) {

    var viewType: Int = -1

    fun bind(item: T) {
        binding.setVariable(BR.item, item)
        binding.executePendingBindings()

        itemView.apply {
            currentSelected?.let {
                isActivated = item == currentSelected
            }
        }
    }
}