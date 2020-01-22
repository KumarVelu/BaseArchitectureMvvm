package com.velu.basearchitecturemvvm.di.module

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import com.velu.basearchitecturemvvm.ui.base.BaseFragment
import com.velu.basearchitecturemvvm.ui.home.HomeViewModel
import com.velu.basearchitecturemvvm.data.local.db.DatabaseService
import com.velu.basearchitecturemvvm.data.remote.NetworkService
import com.velu.basearchitecturemvvm.di.ActivityContext
import com.velu.basearchitecturemvvm.utils.network.NetworkHelper
import com.velu.basearchitecturemvvm.utils.ViewModelProviderFactory
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class FragmentModule(private val fragment: BaseFragment<*>) {

    @ActivityContext
    @Provides
    fun provideContext(): Context = fragment.context!!

    @Provides
    fun provideMainViewModel(
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        databaseService: DatabaseService,
        networkService: NetworkService
    ): HomeViewModel = ViewModelProviders.of(
            fragment, ViewModelProviderFactory(HomeViewModel::class) {
        HomeViewModel(compositeDisposable, networkHelper, databaseService, networkService)
    }).get(HomeViewModel::class.java)
}
