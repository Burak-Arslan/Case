package com.ambluden.myapplication.ui.splash

import androidx.fragment.app.viewModels
import com.ambluden.core.base.BaseFragment
import com.ambluden.core.extension.collect
import com.ambluden.core.extension.isTrue
import com.ambluden.myapplication.R
import com.ambluden.myapplication.databinding.FrSplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FRSplash : BaseFragment<FrSplashBinding>() {

    private val viewModel: FRSplashVM by viewModels()

    override fun getLayoutId() = R.layout.fr_splash

    override fun initViews() {
        viewModel.initVM()
    }

    override fun setListener() {}

    override fun setReceiver() {
        collect(viewModel.navigationNext){
            if(it.isTrue()){
                navigate(FRSplashDirections.toNavHome())
            }
        }
    }
}

