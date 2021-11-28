package com.ambluden.myapplication.ui.home

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import androidx.recyclerview.widget.DiffUtil
import com.ambluden.core.extension.isTrue
import com.ambluden.core.ui.DataBindingAdapter
import com.ambluden.core.ui.DataBindingViewHolder
import com.ambluden.myapplication.R
import com.ambluden.myapplication.databinding.ItemRecItemBinding
import com.ambluden.myapplication.domain.uimodel.SatelliteUI

class AdapterHome : DataBindingAdapter<SatelliteUI>(SatelliteDiffCallBack()) {

    override fun getItemLayoutId(viewType: Int) = R.layout.item_rec_item

    override fun onBindViewHolder(holder: DataBindingViewHolder<SatelliteUI>, position: Int) {
        super.onBindViewHolder(holder, position)
        val item = getItem(position)
        if (item.active.isTrue()) {
            (holder.binding as ItemRecItemBinding).txtStatus.setText(R.string.status_active)
            setImageBackground(holder, 124, 252, 0)
        } else {
            (holder.binding as ItemRecItemBinding).txtStatus.setText(R.string.status_passive)
            setImageBackground(holder, 255, 0, 0)
        }
    }

    private fun setImageBackground(
        holder: DataBindingViewHolder<SatelliteUI>,
        color: Int,
        color2: Int,
        color3: Int
    ) {
        val gd = GradientDrawable()
        gd.shape = GradientDrawable.OVAL
        gd.setColor(Color.rgb(color, color2, color3))
        gd.cornerRadius = 5f
        (holder.binding as ItemRecItemBinding).imgStatus.setImageDrawable(gd)
    }

    class SatelliteDiffCallBack : DiffUtil.ItemCallback<SatelliteUI>() {
        override fun areItemsTheSame(oldItem: SatelliteUI, newItem: SatelliteUI) =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: SatelliteUI, newItem: SatelliteUI) =
            oldItem == newItem
    }
}
