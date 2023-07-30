package com.example.mybaidu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class NewsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

        var backBtn = findViewById<Button>(R.id.news_detail_back)
        backBtn.setOnClickListener{
            finish()
        }
    }
}