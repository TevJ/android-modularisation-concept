package com.techtev.weathermodule.data.weather

import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("/data/2.5/weather")
    fun getWeatherForCity(
        @Query("q") cityName: String,
        @Query("APPID") apiKey: String
    ): Observable<WeatherDataResponse>
}