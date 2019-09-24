package com.techtev.weathermodule.data.weather

import com.techtev.coremodule.base.Lse
import com.techtev.weatherbinder.Weather
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val weatherApi: WeatherApi) {

    fun getWeatherForCity(cityName: String): Observable<Lse<Weather>> {
        return weatherApi.getWeatherForCity(cityName)
            .map<Lse<Weather>> { weatherDataResponse ->
                Lse.Success(weatherDataResponse.mapToDomain())
            }
            .onErrorReturn { e -> Lse.Error(e) }
            .startWithItem(Lse.Loading())
    }

}