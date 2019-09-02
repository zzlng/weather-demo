package com.zzl.weather_demo.domain.commands

import com.zzl.weather_demo.data.ForecastRequest
import com.zzl.weather_demo.domain.mappers.ForecastDataMapper
import com.zzl.weather_demo.domain.model.ForecastList

class RequestForecastCommand(private val zipCode: String) :
    Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return  ForecastDataMapper().convertFromDataModel(
            forecastRequest.execute()
        )
    }
}
