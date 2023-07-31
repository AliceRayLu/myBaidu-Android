package com.example.mybaidu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class NewsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

        val intent = intent
        findViewById<TextView>(R.id.news_detail_title).text = intent.getStringExtra("title")
        findViewById<TextView>(R.id.news_detail_author).text = intent.getStringExtra("author")

        var backBtn = findViewById<Button>(R.id.news_detail_back)
        backBtn.setOnClickListener{
            finish()
        }

        val poem = "Do not go gentle into that good night\n" +
                "Dylan Thomas\n" +
                "1914 – " + "1953\n" +
                "Do not go gentle into that good night,\n" +
                "Old age should burn and rave at close of day;\n" +
                "Rage, rage against the dying of the light.\n" +
                "\n" +
                "Though wise men at their end know dark is right,\n" +
                "Because their words had forked no lightning they\n" +
                "Do not go gentle into that good night.\n" +
                "\n" +
                "Good men, the last wave by, crying how bright\n" +
                "Their frail deeds might have danced in a green bay,\n" +
                "Rage, rage against the dying of the light.\n" +
                "\n" +
                "Wild men who caught and sang the sun in flight,\n" +
                "And learn, too late, they grieved it on its way,\n" +
                "Do not go gentle into that good night.\n" +
                "\n" +
                "Grave men, near death, who see with blinding sight\n" +
                "Blind eyes could blaze like meteors and be gay,\n" +
                "Rage, rage against the dying of the light.\n" +
                "\n" +
                "And you, my father, there on the sad height,\n" +
                "Curse, bless, me now with your fierce tears, I pray.\n" +
                "Do not go gentle into that good night.\n" +
                "Rage, rage against the dying of the light.\n" +
                "\n" +
                "From The Poems of Dylan Thomas, published by New Directions. Copyright © 1952, 1953 Dylan Thomas. Copyright © 1937, 1945, 1955, 1962, 1966, 1967 the Trustees for the Copyrights of Dylan Thomas. Copyright © 1938, 1939, 1943, 1946, 1971 New Directions Publishing Corp. Used with permission."
        findViewById<TextView>(R.id.news_detail_main).text = poem
    }
}