package com.techtev.weathermodule.data.weather

import com.squareup.moshi.JsonClass
import com.techtev.weatherbinder.Weather
import java.math.BigDecimal

@JsonClass(generateAdapter = true)
data class WeatherDataResponse(
    val id: Long,
    val main: MainData,
    val weather: List<WeatherData>
)

@JsonClass(generateAdapter = true)
data class MainData(
    val temp: BigDecimal,
    val pressure: Int
)

@JsonClass(generateAdapter = true)
data class WeatherData(
    val id: Long,
    val main: String,
    val description: String
)

fun WeatherDataResponse.mapToDomain(): Weather {
    return Weather(
        this.id,
        this.weather.first().main,
        this.weather.first().description,
        this.main.temp,
        this.main.pressure
    )
}