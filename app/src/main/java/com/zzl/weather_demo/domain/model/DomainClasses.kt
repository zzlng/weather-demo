package com.zzl.weather_demo.domain.model


data class ForecastList(val city: String, val country: String,
                        val dailyForecast: List<Forecast>) {
    operator fun get(position: Int): Forecast = dailyForecast[position]

    val size: Int
        get() = dailyForecast.size
}

data class Forecast(val date: String, val description: String,
                         val high: Int, val low: Int, val iconUrl: String)