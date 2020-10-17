package com.oman.forward

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.oman.forward.wanandroid.search.SearchAdapter
import com.oman.forward.wanandroid.search.SearchViewModelFactory
import com.oman.forward.wanandroid.search.SearchViewModel
import kotlinx.android.synthetic.main.activity_search.*

inline fun <reified T> startActivity(context: Context) {
    context.startActivity(Intent(context, T::class.java))
}

class SearchActivity : AppCompatActivity() {

    private val viewModel by viewModels<SearchViewModel> {
        SearchViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        val adapter = SearchAdapter(this, mutableListOf())
        val manager = LinearLayoutManager(this)
        recyclerView.layoutManager = manager
        recyclerView.adapter = adapter
        searchAction.addTextChangedListener {
            viewModel.key.postValue(it.toString())
        }

        viewModel.searchResult.observe(this, Observer {
            val result = it.getOrNull()
            if (result != null) {
                adapter.setList(result.data.datas)
            } else {
                Toast.makeText(this, "未查询到信息", Toast.LENGTH_SHORT).show()
                it.exceptionOrNull()?.printStackTrace()
            }
        })
    }
}