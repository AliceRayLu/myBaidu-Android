package com.example.mybaidu.ui.weather


import com.example.mybaidu.databinding.FragmentWeatherBinding
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mybaidu.R
import com.example.mybaidu.data.MyWeaatherHourlyAdapter
import com.example.mybaidu.data.MyWeatherDailyAdapter
import com.example.mybaidu.data.WeatherDaily
import com.example.mybaidu.data.WeatherHourly

class WeatherFragment : Fragment() {
    private var _binding: FragmentWeatherBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var root:View
    private lateinit var hourlyData:ArrayList<WeatherHourly>
    private lateinit var dailyData:ArrayList<WeatherDaily>

    companion object {
        fun newInstance() = WeatherFragment()
    }

    private lateinit var viewModel: WeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)

        _binding = FragmentWeatherBinding.inflate(inflater, container, false)
        root = binding.root

        var recyclerView:RecyclerView = root.findViewById(R.id.weather_hourly)
        initHourData()
        val adapter = MyWeaatherHourlyAdapter(hourlyData,root.context)
        recyclerView.adapter = adapter
        val layoutManager = LinearLayoutManager(root.context)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        recyclerView.layoutManager = layoutManager

        var recyclerView1:RecyclerView = root.findViewById(R.id.weather_daily)
        initDailyData()
        val adapter1 = MyWeatherDailyAdapter(dailyData,root.context)
        recyclerView1.adapter = adapter1
        val layoutManager1 = LinearLayoutManager(root.context)
        layoutManager1.orientation = LinearLayoutManager.VERTICAL
        recyclerView1.layoutManager = layoutManager1

        return root
    }

    private fun initHourData(){
        hourlyData = ArrayList<WeatherHourly>()
        hourlyData.add(WeatherHourly("now","cloudy",18))
        hourlyData.add(WeatherHourly("10am","gloom",17))
        hourlyData.add(WeatherHourly("11am","sunny",18))
        hourlyData.add(WeatherHourly("12am","sunny",18))
        hourlyData.add(WeatherHourly("1pm","cloudy",17))
        hourlyData.add(WeatherHourly("2pm","small_rain",17))
    }

    private fun initDailyData(){
        dailyData = ArrayList<WeatherDaily>()
        dailyData.add(WeatherDaily("Today","cloudy","15°/18°"))
        dailyData.add(WeatherDaily("Tomorrow","sunny","18°/20°"))
        dailyData.add(WeatherDaily("Tue","small_rain","13°/16°"))
    }
}