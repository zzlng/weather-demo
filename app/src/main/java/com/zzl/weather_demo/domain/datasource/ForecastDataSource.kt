package com.zzl.weather_demo.domain.datasource

import com.zzl.weather_demo.domain.model.Forecast
import com.zzl.weather_demo.domain.model.ForecastList

interface ForecastDataSource {

    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?

    fun requestDayForecast(id: Long): Forecast?
}