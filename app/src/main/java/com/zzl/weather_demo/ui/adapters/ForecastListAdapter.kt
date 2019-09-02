package com.zzl.weather_demo.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.zzl.weather_demo.R
import com.zzl.weather_demo.domain.model.Forecast
import com.zzl.weather_demo.domain.model.ForecastList
import com.zzl.weather_demo.ui.utils.ctx
import org.jetbrains.anko.find

class ForecastListAdapter(private val weekForecast: ForecastList,
                          private val itemClick: OnItemClickListener)
    : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : ViewHolder {
        val view = LayoutInflater.from(parent.ctx)
            .inflate(R.layout.item_forecast, parent, false)
//        ViewHolder(TextView(parent.context))
        return ViewHolder(view, itemClick)
    }

//    @SuppressLint("SetTexI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        with(weekForecast[position]) {
//            holder.textView.text = "$date - $description - $high/$low"
//        }
        holder.bindForecast(weekForecast[position])
    }

    override fun getItemCount(): Int = weekForecast.size

    class ViewHolder(view: View, val itemClick: OnItemClickListener)
        : RecyclerView.ViewHolder(view) {

        private val iconView = view.find<ImageView>(R.id.icon)
        private val dateView = view.find<TextView>(R.id.date)
        private val descriptionView = view.find<TextView>(R.id.description)
        private val maxTemperature = view.find<TextView>(R.id.maxTemperature)
        private val minTemperature = view.find<TextView>(R.id.minTemperature)

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.ctx).load(iconUrl).into(iconView)
                dateView.text = date
                descriptionView.text = description
                maxTemperature.text = "${high}º"
                minTemperature.text = "${low}º"
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }

    interface OnItemClickListener {
        operator fun invoke(forecast: Forecast)
    }
}