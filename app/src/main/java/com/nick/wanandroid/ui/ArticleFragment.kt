package com.nick.wanandroid.ui


import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.nick.wanandroid.R
import com.nick.wanandroid.adapters.ArticleAdapter
import com.nick.wanandroid.entity.Article
import com.nick.wanandroid.entity.Result
import com.nick.wanandroid.view_models.HomeViewModel
import kotlinx.android.synthetic.main.fragment_article.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */

class ArticleFragment : Fragment() {
   private val TAG  = "ArticleFragment"
    var homeViewModel: HomeViewModel? = null
   lateinit var  mAdapter: ArticleAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_article, container, false)
    }

    @SuppressLint("WrongConstant")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       Log.d(TAG, "onViewCreated: ")
        rv_article.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        mAdapter = ArticleAdapter(activity!!)
        rv_article.adapter = mAdapter
        getArticle(0)
    }

    private fun getArticle(page: Int) {

        homeViewModel = ViewModelProviders.of(activity!!)[HomeViewModel::class.java]
        homeViewModel?.getArticle(page)?.observe(viewLifecycleOwner, Observer<Result<Article>> {
                Log.d(TAG, "getArticle: ")
            mAdapter.list = it?.data!!.datas

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView: ")
    }
}
