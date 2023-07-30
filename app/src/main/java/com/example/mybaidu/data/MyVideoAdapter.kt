package com.example.mybaidu.data

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.example.mybaidu.NewsDetailActivity
import com.example.mybaidu.R
import com.example.mybaidu.VideoActivity

class MyVideoAdapter(val data:List<VideoInfo>, val context: Context,val activity:FragmentActivity): RecyclerView.Adapter<MyVideoAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        var title:TextView = itemView.findViewById(R.id.video_title)
        var playNum:TextView = itemView.findViewById(R.id.video_playNum)
        var videoPic:View = itemView.findViewById(R.id.video_pic)
        var authorPic:ImageView = itemView.findViewById(R.id.video_author_pic)
        var authorName:TextView = itemView.findViewById(R.id.video_author_name)
        var commentNum:TextView = itemView.findViewById(R.id.video_comments)
        var likeNum:TextView = itemView.findViewById(R.id.video_likes)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = View.inflate(context, R.layout.video_item,null)
        view.setOnClickListener {
            val intent = Intent(activity, VideoActivity::class.java)
            context.startActivity(intent)
        }
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item:VideoInfo = data[position]
        holder.title.text = item.title
        holder.playNum.text = item.playNum.toString()+" play"
        holder.authorName.text = item.authorName
        holder.commentNum.text = item.commentNum.toString()
        holder.likeNum.text = item.likes.toString()
        val option1:RequestOptions = RequestOptions().transform(RoundedCorners(50))
        Glide.with(holder.videoPic.context).load(item.photoPath).apply(option1).
        placeholder(R.drawable.baseline_replay_circle_filled_24).into(
            object : CustomTarget<Drawable>() {
                override fun onResourceReady(
                    resource: Drawable,
                    transition: Transition<in Drawable>?
                ) {
                    holder.videoPic.background = resource
                }

                override fun onLoadCleared(placeholder: Drawable?) {
                    // 当图片加载被清除时的处理逻辑
                }
            }
        )
        val option:RequestOptions = RequestOptions().circleCrop()
        Glide.with(holder.authorPic.context).load(item.authorPic)
            .apply(option).placeholder(R.drawable.baseline_replay_circle_filled_24).into(holder.authorPic)
    }
}