package com.example.nawkhabar.Adapter

import android.content.Context
import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nawkhabar.R
import com.example.nawkhabar.WebActivity
import com.example.nawkhabar.news.Article
import com.example.nawkhabar.news.NewsClass

class NewsAdapter(val context: Context,val articels : List<Article>) : RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view =  LayoutInflater.from(context).inflate(R.layout.newslayout,parent,false)
        return ArticleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  articels.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val articleModel = articels[position]

        holder.newsDescription.text = articleModel.description
        holder.newsHeadline.text = articleModel.title

        holder.itemView.setOnClickListener{
            val intent = Intent(context,WebActivity::class.java)
            intent.putExtra("URL",articleModel.url)
            context.startActivity(intent)
        }

        if (articleModel.urlToImage == null) {
            Glide.with(context).load("https://us.123rf.com/450wm/koblizeek/koblizeek2205/koblizeek220500309/koblizeek220500309.jpg?ver=6").into(holder.newsImage)
        }
        else {
            Glide.with(context).load(articleModel.urlToImage).into(holder.newsImage)
        }



     }

    class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val newsImage : ImageView = itemView.findViewById(R.id.imageview)
        val newsHeadline : TextView = itemView.findViewById(R.id.newsHeadline)
        val newsDescription : TextView = itemView.findViewById(R.id.newsDescription)

    }
}