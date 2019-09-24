package com.techtev.coremodule.di

import com.squareup.moshi.Moshi
import com.techtev.coremodule.adapters.BigDecimalAdapter
import com.techtev.coremodule.annotations.FilmType
import com.techtev.coremodule.annotations.ObserveOn
import com.techtev.coremodule.annotations.SubscribeOn
import com.techtev.coremodule.annotations.WeatherType
import dagger.Module
import dagger.Provides
import dagger.Reusable
import hu.akarnokd.rxjava3.bridge.RxJavaBridge
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.math.BigDecimal
import javax.inject.Singleton

@Module
object BaseModule {
    @JvmStatic
    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder()
        .add(BigDecimal::class.java, BigDecimalAdapter())
        .build()

    @JvmStatic
    @Provides
    @FilmType
    @Singleton
    fun provideFilmRetrofit(moshi: Moshi): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    @JvmStatic
    @Provides
    @WeatherType
    @Singleton
    fun provideWeatherRetrofit(moshi: Moshi): Retrofit = Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    @Provides
    @SubscribeOn
    @JvmStatic
    @Reusable
    fun provideSubscribeScheduler(): Scheduler = Schedulers.io()

    @Provides
    @Reusable
    @JvmStatic
    @ObserveOn
    fun provideObserverScheduler(): Scheduler = RxJavaBridge.toV3Scheduler(AndroidSchedulers.mainThread())
}