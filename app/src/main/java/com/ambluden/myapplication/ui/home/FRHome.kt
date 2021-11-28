package com.ambluden.myapplication.ui.home

import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.ambluden.core.base.BaseFragment
import com.ambluden.core.extension.collect
import com.ambluden.core.extension.injectVM
import com.ambluden.core.extension.isTrue
import com.ambluden.core.util.navGraphViewModels
import com.ambluden.myapplication.R
import com.ambluden.myapplication.databinding.FrHomeBinding
import com.ambluden.myapplication.ui.SharedISatelliteVM
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FRHome : BaseFragment<FrHomeBinding>() {

    private val viewModel: FRHomeVM by injectVM()

    private lateinit var adapterHome: AdapterHome

    private val sharedIdentitySafeVM: SharedISatelliteVM by navGraphViewModels(R.id.FRHome)

    override fun getLayoutId() = R.layout.fr_home

    override fun initViews() {
        adapterHome = AdapterHome()
        vi.mainRecycler.apply {
            adapter = adapterHome
        }
        viewModel.getSatellite()
    }

    override fun setListener() {
        adapterHome.itemClickListener = {
            if (it.active.isTrue()) {
                sharedIdentitySafeVM.resource = resources
                sharedIdentitySafeVM.selectedSatellite = it
                navigate(FRHomeDirections.toFRHomeDetail())
            } else {
                Toast.makeText(context, "Aktif Değil!", Toast.LENGTH_SHORT).show()
            }
        }

        vi.edtSearch.doOnTextChanged { text, _, _, _ ->
            viewModel.filterList(text.toString())
        }
    }

    override fun setReceiver() {
        collect(viewModel.satelliteList) {
            adapterHome.submitList(it)
        }
    }
}