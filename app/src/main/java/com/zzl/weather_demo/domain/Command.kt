package com.zzl.weather_demo.domain

interface Command<T> {
    fun execute(): T
}