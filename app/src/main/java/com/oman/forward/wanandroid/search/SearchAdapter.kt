package com.oman.forward.wanandroid.search

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.oman.base.MyServiceLoader
import com.oman.common.autoservice.IWebViewService
import com.oman.forward.R
import com.oman.forward.wanandroid.entity.Article

class SearchAdapter(val context: Context, var data: List<Article>) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_search, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.author.text = data[position].author
        holder.publishDate.text = data[position].publishTime
        holder.title.text = data[position].title
        holder.itemView.setOnClickListener {
            val service = MyServiceLoader.load(IWebViewService::class.java)
//            service?.startWebView(context, data[position].link, data[position].title, true)
            service?.startDemoHtml(context)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setList(list: List<Article>) {
        data = list
        notifyDataSetChanged()
    }
}

class ViewHolder(rootView: View) : RecyclerView.ViewHolder(rootView) {
    val author: TextView = rootView.findViewById(R.id.searchItemAuthor)
    val publishDate: TextView = rootView.findViewById(R.id.searchItemPublishDate)
    val title: TextView = rootView.findViewById(R.id.searchItemTitle)
}