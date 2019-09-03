package com.zzl.weather_demo.domain.commands

import com.zzl.weather_demo.domain.datasource.ForecastProvider
import com.zzl.weather_demo.domain.model.Forecast

class RequestDayForecastCommand(
    val id: Long,
    private val forecastProvider: ForecastProvider = ForecastProvider()
) : Command<Forecast> {

    override fun execute(): Forecast = forecastProvider.requestForecast(id)
}