package com.velu.basearchitecturemvvm.ui.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.velu.basearchitecturemvvm.ui.base.BaseFragment
import com.velu.basearchitecturemvvm.R
import com.velu.basearchitecturemvvm.di.component.FragmentComponent
import kotlinx.android.synthetic.main.fragment_home.tv_message

class HomeFragment : BaseFragment<HomeViewModel>() {

    companion object {

        val TAG = "HomeFragment"

        fun newInstance(): HomeFragment {
            val args = Bundle()
            val fragment = HomeFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun provideLayoutId(): Int = R.layout.fragment_home

    override fun injectDependencies(fragmentComponent: FragmentComponent) =
            fragmentComponent.inject(this)

    override fun setupView(view: View) {

    }

    override fun setupObservers() {
        super.setupObservers()
        viewModel.testData.observe(this, Observer {
            tv_message.text = it
        })
    }
}
