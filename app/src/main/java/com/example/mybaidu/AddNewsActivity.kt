package com.example.mybaidu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AddNewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_news)

        val backBtn = findViewById<Button>(R.id.add_news_back)
        backBtn.setOnClickListener{
            finish()
        }
    }
}