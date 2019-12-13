package com.oman.forward

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.oman.forward.adapter.CommentsAdapter
import com.oman.forward.databinding.FragmentCommentsBinding
import com.oman.forward.viewmodel.AppDetailViewModel
import com.oman.forward.viewmodel.FactoryProvider

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

        detailModel.app.observe(this, Observer {
            detailModel.myApp.set(it)
        })

        detailModel.comments.observe(this, Observer {
            if (it != null && it.isNotEmpty()) {
                binding.isLoading = false
                adapter.setList(it)
            } else {
                binding.isLoading = true
            }
            binding.executePendingBindings()
        })
    }

    companion object {
        private const val PACKAGE_NAME = "packageName"
    }
}