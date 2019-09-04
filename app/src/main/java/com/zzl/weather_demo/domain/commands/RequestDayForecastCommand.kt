package com.zzl.weather_demo.domain.commands

import com.zzl.weather_demo.domain.datasource.ForecastProvider
import com.zzl.weather_demo.domain.model.Forecast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RequestDayForecastCommand(
    val id: Long,
    private val forecastProvider: ForecastProvider = ForecastProvider()
) : Command<Forecast> {

    override suspend fun execute(): Forecast = withContext(Dispatchers.IO) {
        forecastProvider.requestForecast(id)
    }
}