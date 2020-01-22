package com.velu.basearchitecturemvvm.ui.main

import androidx.lifecycle.MutableLiveData
import com.velu.basearchitecturemvvm.ui.base.BaseViewModel
import com.velu.basearchitecturemvvm.data.local.db.DatabaseService
import com.velu.basearchitecturemvvm.data.remote.NetworkService
import com.velu.basearchitecturemvvm.utils.network.NetworkHelper
import io.reactivex.disposables.CompositeDisposable

class MainViewModel(
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val databaseService: DatabaseService,
    private val networkService: NetworkService
)
    : BaseViewModel(compositeDisposable, networkHelper) {

    val testData = MutableLiveData<String>()

    override fun onCreate() {
        testData.postValue("Hello from MainViewModel")
    }
}
