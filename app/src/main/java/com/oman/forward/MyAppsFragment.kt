package com.oman.forward

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.oman.forward.databinding.FragmentAppsListBinding
import com.oman.forward.databinding.FragmentMyAppsBinding

/**

 * @author:ZhouJiang
 * @date:2019/11/25 12:10
 * @email:zhoujiang2012@163.com

 */
class MyAppsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding: FragmentMyAppsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_apps, container, false)
        return binding.root
    }
}