package com.example.mybaidu

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.MediaController
import android.widget.VideoView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class VideoActivity : AppCompatActivity() {
    private lateinit var videoView:VideoView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        videoView = findViewById<VideoView>(R.id.video_play)
        videoView.setVideoURI(Uri.parse("https://upos-sz-mirrorali.bilivideo.com/upgcxcode/51/89/875888951/875888951-1-208.mp4?e=ig8euxZM2rNcNbhV7zdVhwdlhzdahwdVhoNvNC8BqJIzNbfq9rVEuxTEnE8L5F6VnEsSTx0vkX8fqJeYTj_lta53NCM=&uipk=5&nbs=1&deadline=1690736595&gen=playurlv2&os=alibv&oi=1921313500&trid=0088c838f93b424f9c2fc4045d7952d2T&mid=3493297548953879&platform=html5&upsig=79368d8ba474f28b876869b8375a9a06&uparams=e,uipk,nbs,deadline,gen,os,oi,trid,mid,platform&bvc=vod&nettype=0&bw=307490&orderid=0,1&buvid=&build=0&mobi_app=&logo=80000000"))
        val mediaController = MediaController(this)
        videoView.setMediaController(mediaController)
        videoView.requestFocus()

        val backBtn = findViewById<Button>(R.id.video_back_btn)
        backBtn.setOnClickListener{
            finish()
        }

        val image = findViewById<ImageView>(R.id.video_author_pic_play)
        val option: RequestOptions = RequestOptions().circleCrop()
        Glide.with(image.context).load("https://images.unsplash.com/photo-1641302109117-46d2af1271f3?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=888&q=80")
            .apply(option).placeholder(R.drawable.baseline_replay_circle_filled_24).into(image)
    }

    override fun onResume() {
        super.onResume()
        videoView.start()
    }
}