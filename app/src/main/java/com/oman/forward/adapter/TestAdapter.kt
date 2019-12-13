package com.oman.forward.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.IntDef
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oman.forward.R

/**

 * @author:ZhouJiang
 * @date:2019/10/24 16:26
 * @email:zhoujiang2012@163.com

 */
class TestAdapter(
        private val context: Context,
        private val apps: List<List<String>>,
        private val categories: List<String>,
        private val inflater: LayoutInflater = LayoutInflater.from(context))
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    @IntDef(ITEM_TYPE_CATEGORY, ITEM_TYPE_CAROUSAL)
    @Retention(AnnotationRetention.SOURCE)
    private annotation class ItemType

    override fun onCreateViewHolder(parent: ViewGroup, @ItemType viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == ITEM_TYPE_CATEGORY) {
            CategoryViewHolder(inflater.inflate(R.layout.item_category, parent, false))
        } else {
            CarousalViewHolder(inflater.inflate(R.layout.carousel, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CategoryViewHolder) {
            holder.bind(position)
        } else if (holder is CarousalViewHolder) {
            holder.bind(position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position % 2 == 0) ITEM_TYPE_CATEGORY else ITEM_TYPE_CAROUSAL
    }

    override fun getItemCount(): Int {
        return apps.size * 2
    }

    inner class CategoryViewHolder(container: View) : RecyclerView.ViewHolder(container) {
        private val titleView: TextView = container.findViewById(R.id.category)

        internal fun bind(position: Int) {
            val title = categories[position / 2]
            val list = apps[position / 2]
            if (list.isEmpty()) return
            titleView.text = title
        }
    }

    inner class CarousalViewHolder(container: View) : RecyclerView.ViewHolder(container) {
        private val appList: RecyclerView = container.findViewById(R.id.appList)

        fun bind(position: Int) {
            val manager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            val data = apps[position % 2]
            val adapter = CarousalAdapter(context, data)
            appList.isNestedScrollingEnabled = false
            appList.layoutManager = manager

            appList.adapter = adapter
        }
    }

    companion object {
        private const val ITEM_TYPE_CATEGORY = 0
        private const val ITEM_TYPE_CAROUSAL = 1
    }
}
