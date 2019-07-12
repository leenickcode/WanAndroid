package com.nick.wanandroid.ui


import android.annotation.SuppressLint
import android.os.Bundle
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
    var loginModel :LoginViewModel?=null

    lateinit var  homePageAdapter: HomePageAdapter
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

        loginModel = ViewModelProviders.of(activity!!)[LoginViewModel::class.java]
            loginModel?.loginstate?.observe(viewLifecycleOwner,object:Observer<LoginViewModel.LoginState> {
                override fun onChanged(t: LoginViewModel.LoginState?) {
                    println("HomeFragment")
                    when(t){
                        LoginViewModel.LoginState.FAILD  ->{
                            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_navigation)
                        }
                        LoginViewModel.LoginState.SUCCESS ->{

                        }
                    }
                }
            })

//        tabLayout.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
//            override fun onTabUnselected(p0: TabLayout.Tab?) {
//                println("onTabUnselected"+p0?.text)
//            }
//
//            override fun onTabSelected(p0: TabLayout.Tab?) {
//                println("onTabSelected"+p0?.text)
//            }
//
//            override fun onTabReselected(p0: TabLayout.Tab?) {
//                println("onTabReselected"+p0?.text)
//            }
//
//        })

        homePageAdapter = HomePageAdapter(fragmentManager!!)

        viewpage.adapter = homePageAdapter
        tabLayout.setupWithViewPager(viewpage)



    }

}
