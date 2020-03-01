package com.oman.forward.adapter

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.oman.forward.R

@BindingAdapter("isVisible")
fun show(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("imageUrl")
fun bindImageUrl(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        Glide.with(view.context)
                .asBitmap()
                .load(imageUrl)
                .placeholder(R.mipmap.ic_launcher)
                .centerCrop()
                .into(view)
    }
}