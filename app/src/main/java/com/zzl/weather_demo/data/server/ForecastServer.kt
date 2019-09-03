package com.zzl.weather_demo.data.server

import com.zzl.weather_demo.data.db.ForecastDb
import com.zzl.weather_demo.domain.datasource.ForecastDataSource
import com.zzl.weather_demo.domain.model.ForecastList

class ForecastServer(
    private val dataMapper: ServerDataMapper = ServerDataMapper(),
    private val forecastDb: ForecastDb = ForecastDb()
) : ForecastDataSource {

    override fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList? {
        val result = ForecastByZipCodeRequest(zipCode).execute()
        val converted = dataMapper.convertToDomain(zipCode, result)
        forecastDb.saveForecast(converted)
        return forecastDb.requestForecastByZipCode(zipCode, date)
    }
}