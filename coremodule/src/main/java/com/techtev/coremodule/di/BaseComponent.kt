package com.techtev.coremodule.di

import com.techtev.coremodule.annotations.FilmType
import com.techtev.coremodule.annotations.ObserveOn
import com.techtev.coremodule.annotations.SubscribeOn
import com.techtev.coremodule.annotations.WeatherType
import dagger.Component
import io.reactivex.rxjava3.core.Scheduler
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(modules = [
    BaseModule::class
])
interface BaseComponent {
    @FilmType
    fun filmRetrofit(): Retrofit
    @WeatherType
    fun weatherRetrofit(): Retrofit
    @SubscribeOn
    fun subscribeOnScheduler(): Scheduler
    @ObserveOn
    fun observeOnScheduler(): Scheduler
}