package com.techtev.modularisationconcept.di

import com.techtev.coremodule.annotations.WeatherScope
import com.techtev.weathermodule.di.WeatherDataModule
import com.techtev.weathermodule.presentation.WeatherFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class WeatherInjectionModule {
    @WeatherScope
    @ContributesAndroidInjector
    abstract fun weatherFragment(): WeatherFragment
}