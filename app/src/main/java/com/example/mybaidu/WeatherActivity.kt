package com.example.mybaidu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import com.example.mybaidu.ui.weather.WeatherFragment

class WeatherActivity : AppCompatActivity() {
    lateinit var fragmentTransaction:FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        fragmentTransaction = supportFragmentManager.beginTransaction()
        if (savedInstanceState == null) {
            fragmentTransaction.replace(R.id.container, WeatherFragment.newInstance()).commitNow()
        }
//        val weatherFrag = supportFragmentManager.findFragmentById(R.id.weather)
//        val backBtn = weatherFrag?.view?.findViewById<Button>(R.id.weather_back_btn)
//        backBtn?.setOnClickListener{
//            finish()
////            Log.d("clickEvent","click back btn")
//        }
    }
}