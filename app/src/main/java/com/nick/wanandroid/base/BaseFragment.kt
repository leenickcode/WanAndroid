package com.nick.wanandroid.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * @date 2019/11/8 0008
 * @author nick
 * @Description
 */
abstract  class BaseFragment :Fragment() {
    var  mActivity:Activity?=null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity=context as Activity
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(savedInstanceState)
        initListener()
        businessLogic(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
     val   view = inflater.inflate(getLayoutId(),container,false)

        return view
    }
    abstract fun getLayoutId():Int
    abstract  fun initListener()
    abstract fun businessLogic( savedInstanceState:Bundle?)
    abstract fun init(savedInstanceState:Bundle?)
}