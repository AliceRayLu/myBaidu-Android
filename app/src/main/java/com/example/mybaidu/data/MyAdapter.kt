package com.example.mybaidu.data

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mybaidu.R
import java.net.URL

class MyAdapter(val data:List<News>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = View.inflate(parent.context,R.layout.news_item,null)
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item:News = data[position]
        holder.titleView.text = item.title
        holder.authorView.text = item.author
        if(item.photo != ""){
            Glide.with(holder.photo.context).load(item.photo).placeholder(0).
            thumbnail(0.5f).into(holder.photo)
        }
//        else{
//            holder.photo.visibility = View.GONE
//        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var titleView: TextView = itemView.findViewById(R.id.news_text_head)
        var authorView: TextView = itemView.findViewById(R.id.news_text_author)
        var photo: ImageView = itemView.findViewById(R.id.news_photo)

    }
}