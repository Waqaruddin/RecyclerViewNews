package com.example.recyclerview.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.activities.DetailsActivity
import com.example.recyclerview.models.News
import kotlinx.android.synthetic.main.row_news_adapter.view.*

class AdapterNews(var mContext: Context, var mList:ArrayList<News>): RecyclerView.Adapter<AdapterNews.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.row_news_adapter, parent, false)
        return MyViewHolder(view)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var news = mList.get(position)
        holder.bind(news)
    }

    override fun getItemCount(): Int {
        return mList.size
    }


     inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(news:News){

            itemView.text_view_title.text = news.title
            itemView.text_view_description.text = news.description
            itemView.image_view.setImageResource(news.img)

            itemView.image_view.setOnClickListener {
                Toast.makeText(mContext, "Image", Toast.LENGTH_SHORT).show()
            }

            itemView.setOnClickListener{
                Toast.makeText(mContext, news.title, Toast.LENGTH_SHORT).show()

                var intent = Intent(mContext, DetailsActivity::class.java)
                intent.putExtra("TITLE", news.title)
                intent.putExtra("IMAGE", news.img)
                intent.putExtra("DETAILS", news.details)
                mContext.startActivity(intent)
            }
        }


    }
}