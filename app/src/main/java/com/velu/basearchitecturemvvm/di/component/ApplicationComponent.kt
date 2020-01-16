package com.velu.basearchitecturemvvm.di.component

import android.content.Context
import com.velu.basearchitecturemvvm.MyApplication
import com.velu.basearchitecturemvvm.data.local.DatabaseService
import com.velu.basearchitecturemvvm.data.remote.NetworkService
import com.velu.basearchitecturemvvm.di.ApplicationContext
import com.velu.basearchitecturemvvm.di.module.ApplicationModule
import com.velu.basearchitecturemvvm.utils.NetworkHelper
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: MyApplication)

    @ApplicationContext
    fun getContext(): Context

    fun getNetworkService(): NetworkService

    fun getDatabaseService(): DatabaseService

    fun getNetworkHelper(): NetworkHelper

    fun getCompositeDisposable(): CompositeDisposable
}
