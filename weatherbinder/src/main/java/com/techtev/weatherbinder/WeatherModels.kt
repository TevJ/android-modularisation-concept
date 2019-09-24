package com.techtev.weatherbinder

import java.math.BigDecimal

data class Weather(
    val id: Long,
    val title: String,
    val description: String,
    val temp: BigDecimal,
    val pressure: Int
)