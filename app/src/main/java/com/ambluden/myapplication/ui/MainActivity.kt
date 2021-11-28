package com.ambluden.myapplication.ui

import android.os.Bundle
import com.ambluden.core.base.BaseActivity
import com.ambluden.myapplication.R
import com.ambluden.myapplication.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getLayoutId() = R.layout.activity_main

    override fun initViews(savedInstanceState: Bundle?) {}

    override fun setListener() {}

    override fun setReceiver() {}
}