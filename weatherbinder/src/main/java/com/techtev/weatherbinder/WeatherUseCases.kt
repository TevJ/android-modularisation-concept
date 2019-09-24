package com.techtev.weatherbinder

import com.techtev.coremodule.base.Lse
import com.techtev.coremodule.base.UseCase

interface GetWeatherForCityUseCase: UseCase<Lse<Weather>, String>