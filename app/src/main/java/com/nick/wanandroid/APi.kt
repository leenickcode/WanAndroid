package com.nick.wanandroid

import com.nick.wanandroid.entity.Article
import com.nick.wanandroid.entity.Result
import com.nick.wanandroid.entity.User
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by Administrator on 2019/7/8 0008.
 * @author Administrator
 *
 */

interface APi {
    companion object{
          val BASE_URL = "https://www.wanandroid.com"
    }
    @FormUrlEncoded
    @POST("/user/login")
    fun  login(@Field("username") name :String, @Field("password") password :String ) : Call<Result<User>>

    @GET("article/list/{page}/json")
    fun  getArticle(@Path("page") page:Int ) : Call<Result<Article>>



}