package com.nick.wanandroid.view_models

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
    val homeModel: HomeModel = HomeModel()
    val articleList:MutableLiveData<Result<Article>> = MutableLiveData()
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
}