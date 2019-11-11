package com.nick.wanandroid.view_models

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nick.wanandroid.entity.Article
import com.nick.wanandroid.entity.Result
import com.nick.wanandroid.models.HomeModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Administrator on 2019/7/10 0010.
 * @author Administrator
 */
class HomeViewModel : ViewModel() {
      private val TAG  = "HomeViewModel"
    val homeModel: HomeModel = HomeModel()
    val articleList:MutableLiveData<Result<Article>> = MutableLiveData()
    val collect:MutableLiveData<Result<Any>> = MutableLiveData()
    fun getArticle(page: Int): MutableLiveData<Result<Article>> {
        homeModel.getArticle(page, object : Callback<Result<Article>> {
            override fun onResponse(call: Call<Result<Article>>?, response: Response<Result<Article>>?) {
                articleList.value = response?.body()
            }

            override fun onFailure(call: Call<Result<Article>>?, t: Throwable?) {
            }
        })
        return articleList
    }
      fun  collectArticle(id:Int): MutableLiveData<Result<Any>> {
          homeModel.collect(id,object :Callback<Result<Any>>{
              override fun onFailure(call: Call<Result<Any>>?, t: Throwable?) {

              }

              override fun onResponse(call: Call<Result<Any>>?, response: Response<Result<Any>>?) {
                  Log.d(TAG, "onResponse: ")
                  collect.value=response?.body()
              }

          })
          return collect
      }
}