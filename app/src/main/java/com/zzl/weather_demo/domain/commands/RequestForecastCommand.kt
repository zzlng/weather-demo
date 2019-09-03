package com.zzl.weather_demo.domain.commands

import com.zzl.weather_demo.domain.datasource.ForecastProvider
import com.zzl.weather_demo.domain.model.ForecastList

class RequestForecastCommand(
    private val zipCode: Long,
    private val forecastProvider: ForecastProvider = ForecastProvider()
) :
    Command<ForecastList> {

    companion object {
        const val DAYS = 7
    }

    override fun execute(): ForecastList = forecastProvider.requestByZipCode(zipCode, DAYS)
}
