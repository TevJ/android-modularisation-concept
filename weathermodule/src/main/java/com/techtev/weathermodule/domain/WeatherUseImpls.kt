package com.techtev.weathermodule.domain

import com.techtev.coremodule.annotations.ObserveOn
import com.techtev.coremodule.annotations.SubscribeOn
import com.techtev.coremodule.base.Lse
import com.techtev.coremodule.base.UseCaseImpl
import com.techtev.weatherbinder.GetWeatherForCityUseCase
import com.techtev.weatherbinder.Weather
import com.techtev.weathermodule.data.weather.WeatherRepository
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import javax.inject.Inject

class GetWeatherForCityUseCaseImpl @Inject constructor(
    private val weatherRepository: WeatherRepository,
    @SubscribeOn val subscribeScheduler: Scheduler,
    @ObserveOn val observeScheduler: Scheduler
) : UseCaseImpl<Lse<Weather>, String>(subscribeScheduler, observeScheduler), GetWeatherForCityUseCase {

    override fun buildUseCaseObservable(args: String): Observable<Lse<Weather>> {
        return weatherRepository.getWeatherForCity(args)
    }
}