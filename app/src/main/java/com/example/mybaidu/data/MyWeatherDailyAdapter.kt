package com.example.mybaidu.data

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mybaidu.R

class MyWeatherDailyAdapter(val data:List<WeatherDaily>,val context:Context):RecyclerView.Adapter<MyWeatherDailyAdapter.MyViewHolder>() {
    private val map:Map<String,Int> = mapOf<String,Int>("cloudy" to R.drawable.weather_cloudy,"gloom" to R.drawable.weather_gloom,
        "mid_rain" to R.drawable.weather_mid_rain,"small_rain" to R.drawable.weather_small_rain,
        "sunny" to R.drawable.weather_sunny)

    inner class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        var dateView: TextView = itemView.findViewById(R.id.weather_daily_date)
        var weatherView:ImageView = itemView.findViewById(R.id.weather_daily_weather)
        var tempView:TextView = itemView.findViewById(R.id.weather_daily_temp)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = View.inflate(context, R.layout.weather_daily_item,null)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item:WeatherDaily = data[position]
        holder.dateView.text = item.day
        holder.weatherView.setImageResource(map[item.weather]!!)
        holder.tempView.text = item.temp
    }
}