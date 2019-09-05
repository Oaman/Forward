package com.oman.forward

import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.oman.forward.adapter.DetailBannerAdapter

/**
 * @author:ZhouJiang
 * @date:2019/9/4 23:15
 * @email:zhoujiang2012@163.com
 */
class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = Color.parseColor("#67000000")
        setContentView(R.layout.activity_app_detail)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val recyclerView = findViewById<RecyclerView>(R.id.appList)

        val data = listOf("a","b","c","d","e")
        val mAdapter = DetailBannerAdapter(this, data)
        val manager = LinearLayoutManager(this)
        manager.orientation = RecyclerView.HORIZONTAL
        recyclerView.layoutManager = manager
        recyclerView.adapter = mAdapter
        val helper = PagerSnapHelper()
        helper.attachToRecyclerView(recyclerView)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
