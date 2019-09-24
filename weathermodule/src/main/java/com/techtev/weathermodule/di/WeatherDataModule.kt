package com.techtev.weathermodule.di

import com.techtev.coremodule.annotations.WeatherType
import com.techtev.weathermodule.data.weather.WeatherApi
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit

@Module
class WeatherDataModule {
    @Provides
    @Reusable
    fun provideWeatherApi(@WeatherType retrofit: Retrofit): WeatherApi = retrofit.create(WeatherApi::class.java)
}