package com.nick.wanandroid.models

import com.nick.wanandroid.APi
import com.nick.wanandroid.entity.Article
import com.nick.wanandroid.entity.Result
import com.nick.wanandroid.entity.User
import com.nick.wanandroid.http.RetrofitUtil
import retrofit2.Call
import retrofit2.Callback

/**
 * Created by Administrator on 2019/7/10 0010.
 * @author Administrator
 */
class HomeModel {
    /**
     * 获取首页文章
     */
    fun getArticle(page: Int,  callback: Callback<Result<Article>>): Unit {
        val retrofit =  RetrofitUtil.instance
        val  aPi = retrofit.create(APi::class.java)
        val call : Call<Result<Article>> = aPi.getArticle(page)
        //使用对象表达式来创建匿名内部类
        call.enqueue(callback)
    }

    /**
     * 收藏文章
     */
    fun collect(id:Int,callback: Callback<Result<Any>>){
        val retrofit =  RetrofitUtil.instance
        val  aPi = retrofit.create(APi::class.java)
        val  call  = aPi.collect(id)
        call.enqueue(callback)
    }
}