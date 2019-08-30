package com.zzl.weather_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val forecastList = findViewById(R.id.forecast_list) as RecyclerView
        forecastList.layoutManager = LinearLayoutManager(this)
        forecastList.adapter = ForecastListAdapter(items)
    }

    private val items = listOf(
        "周一 6/23 - 晴 - 31/27",
        "周二 6/24 - 雾 - 21/18",
        "周三 6/25 - 多云 - 22/17",
        "周四 6/26 - 小雨 - 18/11",
        "周五 6/27 - 雾 - 21/17",
        "周六 6/28 - 晴 - 27/21",
        "周日 6/29 - 晴 - 28/19"
    )
}
