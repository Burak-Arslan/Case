package com.ambluden.core.extension.datalistener

import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.ambluden.core.base.BaseActivity
import com.ambluden.core.base.BaseFragment
import com.ambluden.core.base.BaseViewModel
import kotlinx.coroutines.flow.collectLatest

inline fun <reified VM : BaseViewModel> Lazy<VM>.bindingListener(owner: BaseFragment<*>) {
    with(owner) {
        lifecycleScope.launchWhenResumed {
            value.let { vm ->
                vi.lifecycleOwner = owner
                vi.setVariable(5, vm)
                vi.executePendingBindings()
            }
        }
    }
}

inline fun <reified VM : BaseViewModel> Lazy<VM>.viewListener(owner: BaseFragment<*>) {
    with(owner) {
        lifecycleScope.launchWhenCreated {
            this@viewListener.value.let { vm ->
                lifecycleScope.launchWhenCreated {

                    lifecycleScope.launchWhenCreated {
                        vm.navigateDestination.collectLatest {
                            if (activity != null) {
                                (activity as BaseActivity<*>).navigate(it)
                            }
                        }
                    }

                    lifecycleScope.launchWhenCreated {
                        vm.navigateDirection.collectLatest {
                            findNavController().navigate(
                                it.t1.actionId,
                                it.t1.arguments,
                                it.t2,
                                it.t3
                            )
                        }
                    }

                    lifecycleScope.launchWhenCreated {
                        vm.goBack.collectLatest {
                            activity?.onBackPressed()
                        }
                    }

                    lifecycleScope.launchWhenCreated {
                        vm.finish.collectLatest {
                            activity?.finish()
                        }
                    }
                }
            }
        }
    }
}
