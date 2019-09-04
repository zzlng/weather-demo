package com.zzl.weather_demo.ui.activities

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.zzl.weather_demo.R
import com.zzl.weather_demo.domain.commands.RequestForecastCommand
import com.zzl.weather_demo.extensions.DelegatesExt
import com.zzl.weather_demo.ui.adapters.ForecastListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity

class MainActivity : CoroutineScopeActivity(), ToolbarManager {

    private val zipCode: Long by DelegatesExt.preference(
        this,
        SettingsActivity.ZIP_CODE,
        SettingsActivity.DEFAULT_ZIP
    )

    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val forecastList = findViewById(R.id.forecast_list) as RecyclerView
//        val forecastList = find<RecyclerView>(R.id.forecast_list)
        initToolbar()

        forecastList.layoutManager = LinearLayoutManager(this)
        attachToScroll(forecastList)
    }

    override fun onResume() {
        super.onResume()
        loadForecast()
    }

    private fun loadForecast() = launch {
        val result = RequestForecastCommand(94043).execute()
//            val result = RequestForecastCommand(235000).execute()
        val adapter = ForecastListAdapter(result) {
            startActivity<DetailActivity>(
                DetailActivity.ID to it.id,
                DetailActivity.CITY_NAME to result.city
            )
        }
        forecastList.adapter = adapter
        toolbarTitle = "${result.city} (${result.country})"
    }
}
