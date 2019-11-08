package com.nick.wanandroid.ui


import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.nick.wanandroid.R
import com.nick.wanandroid.adapters.ArticleAdapter
import com.nick.wanandroid.base.BaseFragment
import com.nick.wanandroid.callback_interface.ItemClickListener
import com.nick.wanandroid.entity.Article
import com.nick.wanandroid.entity.ArticleData
import com.nick.wanandroid.entity.Result
import com.nick.wanandroid.view_models.HomeViewModel
import kotlinx.android.synthetic.main.fragment_article.*
import kotlinx.android.synthetic.main.item_wenzhang.*


/**
 * A simple [Fragment] subclass.
 *
 */

class ArticleFragment : BaseFragment() {

    private val TAG = "ArticleFragment"


    var homeViewModel: HomeViewModel? = null
    lateinit var mAdapter: ArticleAdapter
    override fun init(savedInstanceState: Bundle?) {
        mAdapter = ArticleAdapter(activity!!)
        homeViewModel = ViewModelProviders.of(activity!!)[HomeViewModel::class.java]
        rv_article.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        rv_article.adapter = mAdapter
    }


    override fun initListener() {
        mAdapter.listener = object : ItemClickListener {
            override fun onClick(any: Any, position: Int, view: View) {
                homeViewModel?.collectArticle((any as ArticleData).id)?.observe(viewLifecycleOwner,
                    Observer<Result<Any>> {
                        if (it.errorCode == 0) {
                            Toast.makeText(context, "收藏成功", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(context, it.errorMsg , Toast.LENGTH_SHORT).show()
                        }
                    })
            }
        }
    }

    override fun businessLogic(savedInstanceState: Bundle?) {

        getArticle(0)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_article
    }


    @SuppressLint("WrongConstant")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun getArticle(page: Int) {
        homeViewModel?.getArticle(page)?.observe(viewLifecycleOwner, Observer<Result<Article>> {
            mAdapter.list = it?.data!!.datas
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView: ")
    }
}
