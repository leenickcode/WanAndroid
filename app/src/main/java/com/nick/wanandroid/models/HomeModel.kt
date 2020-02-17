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
  suspend  fun getArticle(page: Int): Result<Article> {
        val retrofit =  RetrofitUtil.instance
        val  aPi = retrofit.create(APi::class.java)
        return  aPi.getArticle(page)
    }

    /**
     * 收藏文章
     */
  suspend  fun collect(id:Int):Result<Any>{
        val retrofit =  RetrofitUtil.instance
        val  aPi = retrofit.create(APi::class.java)
        return aPi.collect(id)
    }
}