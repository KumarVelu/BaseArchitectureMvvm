package com.velu.basearchitecturemvvm.di.component

import com.velu.basearchitecturemvvm.di.FragmentScope
import com.velu.basearchitecturemvvm.di.module.FragmentModule
import com.velu.basearchitecturemvvm.ui.home.HomeFragment

import dagger.Component

@FragmentScope
@Component(dependencies = [ApplicationComponent::class], modules = [FragmentModule::class])
interface FragmentComponent {

    fun inject(fragment: HomeFragment)
}
