package com.nick.wanandroid.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.nick.wanandroid.R
import com.nick.wanandroid.adapters.ProjectAdapter
import com.nick.wanandroid.entity.Article
import com.nick.wanandroid.entity.ArticleData
import com.nick.wanandroid.entity.Result
import com.nick.wanandroid.http.RetrofitUtil
import com.nick.wanandroid.models.LoginModel
import com.nick.wanandroid.view_models.HomeViewModel
import com.nick.wanandroid.view_models.LoginViewModel
import kotlinx.android.synthetic.main.fragment_home.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */

class HomeFragment : Fragment() {
    var loginModel :LoginViewModel?=null
    var homeViewModel :HomeViewModel ?= null

     lateinit var  mAdapter:ProjectAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        loginModel = ViewModelProviders.of(activity!!)[LoginViewModel::class.java]
            loginModel?.loginstate?.observe(viewLifecycleOwner,object:Observer<LoginViewModel.LoginState> {
                override fun onChanged(t: LoginViewModel.LoginState?) {
                    when(t){
                        LoginViewModel.LoginState.FAILD  ->{
                            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_navigation)
                        }
                        LoginViewModel.LoginState.SUCCESS ->{

                        }
                    }
                }
            })

        textView2.setOnClickListener {
            println("ajhaa")
            val list : List<ArticleData> = listOf()
            mAdapter.list = list

        }


        mAdapter = ProjectAdapter(activity!!)
        rv_home.adapter =mAdapter
        rv_home.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)

            getArticle(0)
    }
    fun getArticle(page: Int): Unit {

        homeViewModel = ViewModelProviders.of(activity!!)[HomeViewModel::class.java]
        homeViewModel?.getArticle(page)?.observe(viewLifecycleOwner,Observer<Result<Article>> {
            mAdapter.list = it?.data!!.datas

        })
    }
}
