package com.nick.wanandroid.ui


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import com.nick.wanandroid.R
import com.nick.wanandroid.adapters.ProjectAdapter
import com.nick.wanandroid.callback_interface.ItemClickListener
import com.nick.wanandroid.view_models.ProjectViewModel
import kotlinx.android.synthetic.main.fragment_project.*

class ProjectFragment : Fragment() {
    private val TAG = "ProjectFragment"
    lateinit var viewModel: ProjectViewModel
    lateinit var mAdapter: ProjectAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_project, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_project.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        mAdapter = ProjectAdapter(activity!!)
        rv_project.adapter = mAdapter
        viewModel = ViewModelProviders.of(this)[ProjectViewModel::class.java]
        viewModel.getProjectTypes().observe(this, Observer {
            viewModel.getProjects(it[0].id).observe(this, Observer {
                mAdapter.list = it.datas
            })
        })
        mAdapter.listener = object : ItemClickListener {
            override fun onClick(any: Any, position: Int, view: View) {
                val action =
                    HomeFragmentDirections.actionHomeFragmentToBlogDetailFragment(mAdapter.list[position])
                findNavController().navigate(action)
            }
        }
        mAdapter.listener= object : ItemClickListener {
            override fun onClick(any: Any, position: Int, view: View) {

            }
        }
    }
}
