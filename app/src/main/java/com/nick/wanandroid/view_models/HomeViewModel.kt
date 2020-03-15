package com.nick.wanandroid.view_models

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nick.wanandroid.entity.Article
import com.nick.wanandroid.entity.Result
import com.nick.wanandroid.models.HomeModel
import kotlinx.coroutines.launch
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
     val unCollect:MutableLiveData<Result<Any>> = MutableLiveData()
    fun getArticle(page: Int): MutableLiveData<Result<Article>> {
        viewModelScope.launch {
           articleList.value= homeModel.getArticle(page)
        }
        return articleList
    }

    /**
     * 收藏文章，
     */
    fun  collectArticle(id:Int): MutableLiveData<Result<Any>> {
          viewModelScope.launch {
              collect.value=  homeModel.collect(id)
          }
          return collect
      }

    fun  unCollect(id: Int){
        viewModelScope.launch {
//            Log.d(TAG, "unCollect: HomeViewModel")
            unCollect.value=  homeModel.unCollect(id)

        }

    }
}