package com.oman.forward

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.oman.forward.adapter.CommentsAdapter
import com.oman.forward.study.rxjava.DataBean
import com.oman.forward.study.rxjava.RepoBean
import com.oman.forward.study.rxjava.TestInterface
import com.oman.forward.databinding.FragmentCommentsBinding
import com.oman.forward.viewmodel.AppDetailViewModel
import com.oman.forward.viewmodel.FactoryProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CommentsFragment : Fragment() {

    private val detailModel: AppDetailViewModel by viewModels {
        FactoryProvider.providerAppDetailFactory(requireContext(),
                arguments?.getString(PACKAGE_NAME)!!)
    }

    private lateinit var binding: FragmentCommentsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_comments, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.viewModel = detailModel
        val adapter = CommentsAdapter()
        binding.commentsList.adapter = adapter

        detailModel.app.observe(viewLifecycleOwner, Observer {
            detailModel.myApp.set(it)
        })

        detailModel.comments.observe(viewLifecycleOwner, Observer {
            if (it != null && it.isNotEmpty()) {
                binding.isLoading = false
                adapter.setList(it)
            } else {
                binding.isLoading = true
            }
            binding.executePendingBindings()
        })

        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val api = retrofit.create(TestInterface::class.java)
        api.githubOman.enqueue(object : Callback<DataBean> {
            override fun onFailure(call: Call<DataBean>, t: Throwable) {
                Log.i("aaa", "exception: $t")

            }

            override fun onResponse(call: Call<DataBean>, response: Response<DataBean>) {
                Log.i("aaa", "reponse: " + response.body().toString() + "--thread:${Thread.currentThread().name}")
            }

        })

        api.getRepos("oaman").enqueue(object : Callback<List<RepoBean>> {
            override fun onFailure(call: Call<List<RepoBean>>, t: Throwable) {
                Log.i("aaa", "exception2: $t")

            }

            override fun onResponse(call: Call<List<RepoBean>>, response: Response<List<RepoBean>>) {
                Log.i("aaa", "reponse2: " + response.body().toString() + "--thread:${Thread.currentThread().name}")
                val a = response.body()
                Log.i("aaa", "aa: " + a?.size)
            }

        })


    }

    fun getList(): List<String>? {
        return null
    }

    companion object {
        private const val PACKAGE_NAME = "packageName"
    }
}