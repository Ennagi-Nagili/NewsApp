package com.annaginagili.newsapp

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.w3c.dom.Text

class NewsAdapter (val context: Context, list : List<News>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    var list : List<News>
    init {
        this.list=list
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title = itemView.findViewById<TextView>(R.id.name)
        var time = itemView.findViewById<TextView>(R.id.time)
        var image = itemView.findViewById<ImageView>(R.id.image)
        var description = itemView.findViewById<TextView>(R.id.creator)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.news_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.setText(list.get(position).title)
        holder.time.setText(list.get(position).pubDate)
        holder.description.setText(list.get(position).description)
        Glide.with(context).load(list.get(position).image_url).into(holder.image)
    }
}