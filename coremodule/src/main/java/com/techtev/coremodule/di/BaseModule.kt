package com.techtev.coremodule.di

import com.techtev.coremodule.annotations.ObserveOn
import com.techtev.coremodule.annotations.SubscribeOn
import dagger.Module
import dagger.Provides
import dagger.Reusable
import hu.akarnokd.rxjava3.bridge.RxJavaBridge
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class BaseModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    @Provides
    @Reusable
    @SubscribeOn
    fun provideSubscribeScheduler(): Scheduler = Schedulers.io()

    @Provides
    @Reusable
    @ObserveOn
    fun provideObserverScheduler(): Scheduler = RxJavaBridge.toV3Scheduler(AndroidSchedulers.mainThread())
}