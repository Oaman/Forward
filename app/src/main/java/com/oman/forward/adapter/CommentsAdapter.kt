package com.oman.forward.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.oman.forward.R
import com.oman.forward.databinding.ItemCommentBinding
import com.oman.forward.db.entity.CommentEntity

class CommentsAdapter : RecyclerView.Adapter<CommentsAdapter.AppListViewHolder>() {

    private var comments: List<CommentEntity> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppListViewHolder {
        return AppListViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                R.layout.item_comment, parent, false))
    }

    override fun getItemCount(): Int {
        return comments.size
    }

    override fun onBindViewHolder(holder: AppListViewHolder, position: Int) {
        holder.binding.comment = comments[position]
    }

    fun setList(apps: List<CommentEntity>) {
        this.comments = apps
        notifyDataSetChanged()
    }

    class AppListViewHolder(var binding: ItemCommentBinding) : RecyclerView.ViewHolder(binding.root)
}