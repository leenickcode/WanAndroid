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
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayout
import com.nick.wanandroid.R
import com.nick.wanandroid.adapters.HomePageAdapter
import com.nick.wanandroid.adapters.ProjectAdapter
import com.nick.wanandroid.entity.Article
import com.nick.wanandroid.entity.ArticleData
import com.nick.wanandroid.entity.Result
import com.nick.wanandroid.http.RetrofitUtil
import com.nick.wanandroid.models.LoginModel
import com.nick.wanandroid.view_models.HomeViewModel
import com.nick.wanandroid.view_models.LoginViewModel
import kotlinx.android.synthetic.main.fragment_home.*


/**
 * A simple [Fragment] subclass.
 *
 */

class HomeFragment : Fragment() {
    var loginModel: LoginViewModel? = null
    private val TAG = "HomeFragment"
    lateinit var homePageAdapter: HomePageAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    @SuppressLint("WrongConstant")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: ")
        loginModel = ViewModelProviders.of(activity!!)[LoginViewModel::class.java]
        homePageAdapter = HomePageAdapter(childFragmentManager)

        viewpage.adapter = homePageAdapter
        tabLayout.setupWithViewPager(viewpage)


    }

}
