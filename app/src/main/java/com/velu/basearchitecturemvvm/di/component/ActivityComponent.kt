package com.velu.basearchitecturemvvm.di.component

import com.velu.basearchitecturemvvm.di.ActivityScope
import com.velu.basearchitecturemvvm.di.module.ActivityModule
import com.velu.basearchitecturemvvm.ui.main.MainActivity

import dagger.Component

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: MainActivity)
}
