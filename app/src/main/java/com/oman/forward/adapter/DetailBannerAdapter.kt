package com.oman.forward.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.oman.forward.R

/**
 * @author:ZhouJiang
 * @date:2019/9/9 10:34
 * @email:zhoujiang2012@163.com
 */
class DetailBannerAdapter(private val mContext: Context, private val mData: List<String>) : RecyclerView.Adapter<DetailBannerAdapter.AppDetailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppDetailViewHolder {
        return AppDetailViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_detail, parent, false))
    }

    override fun onBindViewHolder(holder: AppDetailViewHolder, position: Int) {
        holder.highlightBanner.setImageResource(R.drawable.banner)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    inner class AppDetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var highlightBanner: ImageView = itemView.findViewById(R.id.highlightBanner)
    }
}
