package com.oman.forward.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.oman.forward.R
import com.oman.forward.callback.OnAppItemClickListener
import com.oman.forward.databinding.ItemAppBinding
import com.oman.forward.db.entity.AppEntity

class AppListAdapter(private val callback: OnAppItemClickListener) : RecyclerView.Adapter<AppListAdapter.AppListViewHolder>() {

    private var apps: List<AppEntity> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppListViewHolder {
        return AppListViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.item_app, parent, false))
    }

    override fun getItemCount(): Int {
        return apps.size
    }

    override fun onBindViewHolder(holder: AppListViewHolder, position: Int) {
        holder.binding.app = apps[position]
        holder.binding.callback = callback
    }

    fun setList(apps: List<AppEntity>) {
        this.apps = apps
        notifyDataSetChanged()
    }


    class AppListViewHolder(var binding: ItemAppBinding) : RecyclerView.ViewHolder(binding.root)
}