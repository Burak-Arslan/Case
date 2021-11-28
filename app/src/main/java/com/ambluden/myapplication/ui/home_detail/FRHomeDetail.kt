package com.ambluden.myapplication.ui.home_detail

import android.annotation.SuppressLint
import androidx.fragment.app.viewModels
import com.ambluden.core.base.BaseFragment
import com.ambluden.core.extension.collect
import com.ambluden.core.util.navGraphViewModels
import com.ambluden.myapplication.R
import com.ambluden.myapplication.databinding.FrHomeDetailBinding
import com.ambluden.myapplication.ui.SharedISatelliteVM
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*


@AndroidEntryPoint
class FRHomeDetail : BaseFragment<FrHomeDetailBinding>() {

    private val viewModel: FRHomeDetailVM by viewModels()

    override fun getLayoutId() = R.layout.fr_home_detail

    private val sharedIdentitySafeVM: SharedISatelliteVM by navGraphViewModels(R.id.FRHome)

    override fun initViews() {
        viewModel.selectedSatellite = sharedIdentitySafeVM.selectedSatellite
        viewModel.resources = sharedIdentitySafeVM.resource
        viewModel.getSatelliteDetailPosition()
        startRepeatingJob(3000)
    }

    override fun setListener() {}

    @SuppressLint("SetTextI18n")
    override fun setReceiver() {
        collect(viewModel.satelliteDetailList) {
            if (it != null) {
                it!!.forEach { item ->
                    if (item.id == sharedIdentitySafeVM.selectedSatellite?.id) {
                        vi.txtName.text = sharedIdentitySafeVM.selectedSatellite?.name
                        vi.txtDate.text = item.first_flight
                        vi.txtCostValue.text = item.cost_per_launch.toString()
                        vi.txtHeight.text = item.height.toString() + "/" + item.mass.toString()
                    }
                }
            }
        }
    }

    @OptIn(InternalCoroutinesApi::class)
    private fun startRepeatingJob(timeInterval: Long): Job {
        return CoroutineScope(Dispatchers.Default).launch {
            while (NonCancellable.isActive) {
                viewModel.getPosition(resources!!)
                setScreenPosition()
                delay(timeInterval)
            }
        }
    }

    private fun setScreenPosition() {
        if (viewModel.positionList != null) {
            viewModel.positionList!!.list?.forEach { item ->
                item.let {
                    if (item?.id.equals(sharedIdentitySafeVM.selectedSatellite?.id.toString())) {
                        var lastPosition = item?.positions?.random()
                        runBlocking(Dispatchers.Main) {
                            vi.txtLastPositionValue.text =
                                lastPosition?.posX.toString() + "," + lastPosition?.posY.toString()
                        }
                    }
                }
            }
        }
    }
}

