package com.oman.forward

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oman.forward.adapter.TestAdapter

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.title = "Home"
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val categories = resources.getStringArray(R.array.categories).toList()
        val names = resources.getStringArray(R.array.names).toList()
        val namesAll = listOf(names, names, names, names, names)
        val appList = findViewById<RecyclerView>(R.id.appList)
        val adapter = TestAdapter(this, namesAll, categories)
        val manager = LinearLayoutManager(this)
        appList.layoutManager = manager
        appList.adapter = adapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
