package com.velu.basearchitecturemvvm.ui.main

import android.os.Bundle
import androidx.lifecycle.Observer
import com.velu.basearchitecturemvvm.ui.home.HomeFragment
import com.velu.basearchitecturemvvm.ui.base.BaseActivity
import com.velu.basearchitecturemvvm.R
import com.velu.basearchitecturemvvm.di.component.ActivityComponent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainViewModel>() {

    override fun provideLayoutId(): Int = R.layout.activity_main

    override fun injectDependencies(activityComponent: ActivityComponent) = activityComponent.inject(this)

    override fun setupView(savedInstanceState: Bundle?) {
        addHomeFragment()
    }

    override fun setupObservers() {
        super.setupObservers()
        viewModel.testData.observe(this, Observer {
            tv_message.text = it
        })
    }

    private fun addHomeFragment() {
        if (supportFragmentManager.findFragmentByTag(HomeFragment.TAG) == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container_fragment, HomeFragment.newInstance(), HomeFragment.TAG)
                .commit()
        }
    }
}
