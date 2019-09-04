package com.zzl.weather_demo.domain.commands

interface Command<out T> {
    suspend fun execute(): T
}