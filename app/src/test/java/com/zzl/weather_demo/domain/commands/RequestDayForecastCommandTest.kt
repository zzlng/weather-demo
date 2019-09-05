package com.zzl.weather_demo.domain.commands

import com.zzl.weather_demo.domain.datasource.ForecastProvider
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class RequestDayForecastCommandTest {

    @Test
    fun `provider is called when command is executed`() {
        val forecastProvider = mock(ForecastProvider::class.java)
        val command = RequestDayForecastCommand(2, forecastProvider)
        runBlocking { command.execute() }
        verify(forecastProvider).requestForecast(2)
    }
}