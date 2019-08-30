package com.zzl.weather_demo.domain

import com.zzl.weather_demo.data.ForecastRequest
import com.zzl.weather_demo.domain.model.ForecastList

class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return  ForecastDataMapper().convertFromDataModel(
            forecastRequest.execute()
        )
    }
}