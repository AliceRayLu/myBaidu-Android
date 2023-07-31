package com.example.mybaidu.data

import android.content.Context
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.mybaidu.NewsDetailActivity
import com.example.mybaidu.R

class MyNewsAdapter(val data:List<News>, val context: Context,val activity: FragmentActivity): RecyclerView.Adapter<MyNewsAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = View.inflate(context,R.layout.news_item,null)
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        view.setOnClickListener {
            val intent = Intent(activity,NewsDetailActivity::class.java)
            intent.putExtra("title",view.findViewById<TextView>(R.id.news_text_head).text)
            intent.putExtra("author",view.findViewById<TextView>(R.id.news_text_author).text)
            context.startActivity(intent)
        }
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item:News = data[position]
        holder.titleView.text = item.title
        holder.authorView.text = item.author
        if(item.photo != ""){
            val option:RequestOptions = RequestOptions().transform(RoundedCorners(50))
            Glide.with(holder.photo.context).load(item.photo).apply(option).
            placeholder(R.drawable.baseline_replay_circle_filled_24).into(holder.photo)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleView: TextView = itemView.findViewById(R.id.news_text_head)
        var authorView: TextView = itemView.findViewById(R.id.news_text_author)
        var photo: ImageView = itemView.findViewById(R.id.news_photo)
        var photowrapper:View = itemView.findViewById(R.id.news_photo_wrap)
    }
}