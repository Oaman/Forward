package com.oman.forward.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.oman.forward.DetailActivity
import com.oman.forward.R

/**

 * @author:ZhouJiang
 * @date:2019/10/24 21:05
 * @email:zhoujiang2012@163.com

 */
class CarousalAdapter(
        private val context: Context,
        private val list: List<String>)
    : RecyclerView.Adapter<CarousalAdapter.ViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.item_carousel, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bing(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(private val container: View) : RecyclerView.ViewHolder(container) {
        private val nameView: TextView = container.findViewById(R.id.item_name)

        fun bing(position: Int) {
            val name = list[position]
            nameView.text = name
            container.setOnClickListener {
                context.startActivity(Intent(context, DetailActivity::class.java))
            }
        }
    }
}