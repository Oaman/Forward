package com.oman.forward

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oman.forward.adapter.DashAdapter

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.title = "Home"

        val categories = resources.getStringArray(R.array.categories).toList()
        val names = resources.getStringArray(R.array.names).toList()
        val namesAll = listOf(names, names, names, names, names)
        val appList = findViewById<RecyclerView>(R.id.appList)
        val adapter = DashAdapter(this, namesAll, categories)
        val manager = LinearLayoutManager(this)
        appList.layoutManager = manager
        appList.adapter = adapter
    }
}
