package com.nick.wanandroid.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.nick.wanandroid.R
import com.nick.wanandroid.adapters.ProjectAdapter
import com.nick.wanandroid.view_models.ProjectViewModel
import kotlinx.android.synthetic.main.fragment_project.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ProjectFragment : Fragment() {
    lateinit var viewModel:ProjectViewModel
    lateinit var  mAdapter:ProjectAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_project, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_project.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
        mAdapter = ProjectAdapter(activity!!)
        rv_project.adapter = mAdapter
        viewModel= ViewModelProviders.of(this)[ProjectViewModel::class.java]
        viewModel.getProjectTypes().observe(this, Observer {
            viewModel.getProjects(it[0].id).observe(this, Observer {
                mAdapter.list = it.datas
            })
        })
    }
}
