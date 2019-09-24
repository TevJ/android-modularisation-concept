package com.techtev.weathermodule.di

import com.techtev.weatherbinder.GetWeatherForCityUseCase
import com.techtev.weathermodule.domain.GetWeatherForCityUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
abstract class WeatherUseCasesModule {
    @Binds
    abstract fun provideGetWeatherForCityUseCase(
        getWeatherForCityUseCaseImpl: GetWeatherForCityUseCaseImpl
    ): GetWeatherForCityUseCase
}