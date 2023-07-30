package com.example.mybaidu.data

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mybaidu.R

class MyWeaatherHourlyAdapter(val data:List<WeatherHourly>, val context: Context):
    RecyclerView.Adapter<MyWeaatherHourlyAdapter.MyViewHolder>() {

    private val map:Map<String,Int> = mapOf<String,Int>("cloudy" to R.drawable.weather_cloudy,"gloom" to R.drawable.weather_gloom,
        "mid_rain" to R.drawable.weather_mid_rain,"small_rain" to R.drawable.weather_small_rain,
        "sunny" to R.drawable.weather_sunny)

    inner class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        var timeView: TextView = itemView.findViewById(R.id.weather_hourly_time)
        var picView:ImageView = itemView.findViewById(R.id.weather_hourly_pic)
        var tempView:TextView = itemView.findViewById(R.id.weather_hourly_temp)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = View.inflate(context, R.layout.weather_hourly_item,null)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item:WeatherHourly = data[position]
        holder.timeView.text = item.time
        holder.picView.setImageResource(map[item.pic]!!)
        holder.tempView.text = item.temp.toString()+"℃"
    }
}