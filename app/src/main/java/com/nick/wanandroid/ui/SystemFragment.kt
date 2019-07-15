package com.nick.wanandroid.ui


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.nick.wanandroid.R
import com.nick.wanandroid.adapters.SystemAdapter
import com.nick.wanandroid.view_models.SystemViewModel

import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.nick.wanandroid.entity.SystemBean
import kotlinx.android.synthetic.main.fragment_system.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *  体系
 */
class SystemFragment : Fragment() {
   lateinit var systemViewModel :SystemViewModel
    lateinit var mAdapter: SystemAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_system, container, false)
    }

    @SuppressLint("WrongConstant")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        systemViewModel=ViewModelProviders.of(this)[SystemViewModel::class.java]
        systemViewModel.getSystemTree().observe(this, Observer {
                mAdapter.data = it as MutableList<SystemBean>
        })
        mAdapter = SystemAdapter(activity!!)
        recyclerView.adapter = mAdapter
        recyclerView.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)


    }
}
