package com.velu.basearchitecturemvvm.di.module

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import com.velu.basearchitecturemvvm.ui.base.BaseActivity
import com.velu.basearchitecturemvvm.ui.main.MainViewModel
import com.velu.basearchitecturemvvm.data.local.db.DatabaseService
import com.velu.basearchitecturemvvm.data.remote.NetworkService
import com.velu.basearchitecturemvvm.di.ActivityContext
import com.velu.basearchitecturemvvm.utils.network.NetworkHelper
import com.velu.basearchitecturemvvm.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ActivityModule(private val activity: BaseActivity<*>) {

    @ActivityContext
    @Provides
    fun provideContext(): Context = activity

    @Provides
    fun provideMainViewModel(
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        databaseService: DatabaseService,
        networkService: NetworkService
    ): MainViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(MainViewModel::class) {
            MainViewModel(compositeDisposable, networkHelper, databaseService, networkService)
        }).get(MainViewModel::class.java)
}