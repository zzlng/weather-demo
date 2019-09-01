package com.zzl.weather_demo.domain.commands

interface Command<T> {
    fun execute(): T
}