package com.oman.forward

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.oman.forward.adapter.AppListAdapter
import com.oman.forward.callback.OnAppItemClickListener
import com.oman.forward.databinding.FragmentAppsListBinding
import com.oman.forward.db.entity.AppEntity
import com.oman.forward.viewmodel.AppsViewModel
import com.oman.forward.viewmodel.FactoryProvider

/**

 * @author:ZhouJiang
 * @date:2019/11/25 12:10
 * @email:zhoujiang2012@163.com

 */
class AppsListFragment : Fragment() {

    private val viewModel: AppsViewModel by viewModels {
        FactoryProvider.providerAppsFactory(requireContext())
    }

    private lateinit var adapter: AppListAdapter

    private lateinit var binding: FragmentAppsListBinding

    private val TAG: String by lazy {
        AppsListFragment::class.java.simpleName
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_apps_list, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapter = AppListAdapter(object : OnAppItemClickListener {
            override fun onItemClick(app: AppEntity) {
                val bundle = Bundle()
                bundle.putString(PACKAGE_NAME, app.packageName)
                findNavController().navigate(R.id.action_apps_list_fragment_to_comments_detail_fragment, bundle)
            }
        })
        binding.appList.adapter = adapter
        viewModel.apps.observe(viewLifecycleOwner, Observer {
            if (it.isNullOrEmpty()) {
                binding.loading = true
            } else {
                binding.loading = false
                adapter.setList(it)
            }
            binding.executePendingBindings()
        })
    }

    companion object {
        private const val PACKAGE_NAME = "packageName"
    }
}