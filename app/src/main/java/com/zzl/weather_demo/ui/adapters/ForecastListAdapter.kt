package com.zzl.weather_demo.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.zzl.weather_demo.R
import com.zzl.weather_demo.domain.model.Forecast
import com.zzl.weather_demo.domain.model.ForecastList
import com.zzl.weather_demo.extensions.ctx
import com.zzl.weather_demo.extensions.toDateString
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_forecast.*

class ForecastListAdapter(
    private val weekForecast: ForecastList,
    private val itemClick: (Forecast) -> Unit
) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : ViewHolder {
        val view = LayoutInflater.from(parent.ctx)
            .inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    @SuppressLint("SetTexI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        with(weekForecast[position]) {
//            holder.textView.text = "$date - $description - $high/$low"
//        }
        holder.bindForecast(weekForecast[position])
    }

    override fun getItemCount() = weekForecast.size

    class ViewHolder(override val containerView: View, private val itemClick: (Forecast) -> Unit) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.ctx).load(iconUrl).into(icon)
                dateText.text = date.toDateString()
                descriptionText.text = description
                maxTemperature.text = "${high}º"
                minTemperature.text = "${low}º"
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }
}