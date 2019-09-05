package com.zzl.weather_demo.domain.datasource

import com.zzl.weather_demo.data.db.ForecastDb
import com.zzl.weather_demo.data.server.ForecastServer
import com.zzl.weather_demo.domain.model.Forecast
import com.zzl.weather_demo.domain.model.ForecastList
import com.zzl.weather_demo.extensions.firstResult

class ForecastProvider(private val sources: List<ForecastDataSource> = SOURCES) {

    companion object {
        const val DAY_IN_MILLIS = 1000 * 60 * 60 * 24
        val SOURCES by lazy { listOf(ForecastDb(), ForecastServer()) }
    }

    fun requestByZipCode(zipCode: Long, days: Int): ForecastList = requestToSources {
        val res = it.requestForecastByZipCode(zipCode, todayTimeSpan())
        if (res != null && res.size >= days) res else null
    }

    fun requestForecast(id: Long): Forecast = requestToSources { it.requestDayForecast(id) }

    private fun todayTimeSpan() = System.currentTimeMillis() / DAY_IN_MILLIS * DAY_IN_MILLIS

    private fun <T : Any> requestToSources(f: (ForecastDataSource) -> T?): T =
        sources.firstResult { f(it) }
}