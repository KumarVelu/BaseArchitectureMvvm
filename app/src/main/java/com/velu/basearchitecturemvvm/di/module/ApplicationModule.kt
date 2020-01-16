package com.velu.basearchitecturemvvm.di.module

import android.content.Context

import com.velu.basearchitecturemvvm.MyApplication
import com.velu.basearchitecturemvvm.di.ApplicationContext
import com.velu.basearchitecturemvvm.di.DatabaseInfo
import com.velu.basearchitecturemvvm.di.NetworkInfo

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ApplicationModule(private val application: MyApplication) {

    @ApplicationContext
    @Provides
    fun provideContext(): Context = application

    @Provides
    @DatabaseInfo
    fun provideDatabaseName(): String = "dummy_db"

    @Provides
    @DatabaseInfo
    fun provideDatabaseVersion(): Int = 1

    @Provides
    @NetworkInfo
    fun provideApiKey(): String = "SOME_API_KEY"

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()
}
