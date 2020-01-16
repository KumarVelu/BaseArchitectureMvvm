package com.velu.basearchitecturemvvm.ui.home

import androidx.lifecycle.MutableLiveData
import com.velu.basearchitecturemvvm.ui.base.BaseViewModel
import com.velu.basearchitecturemvvm.data.local.DatabaseService
import com.velu.basearchitecturemvvm.data.remote.NetworkService
import com.velu.basearchitecturemvvm.utils.NetworkHelper
import io.reactivex.disposables.CompositeDisposable

class HomeViewModel constructor(
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val databaseService: DatabaseService,
    private val networkService: NetworkService
) : BaseViewModel(compositeDisposable, networkHelper) {

    val testData = MutableLiveData<String>()

    override fun onCreate() {
        testData.postValue("Hello from MainViewModel")
    }
}
