package com.oman.forward.callback

import com.oman.forward.db.entity.AppEntity

interface OnAppItemClickListener {
    fun onItemClick(app: AppEntity)
}