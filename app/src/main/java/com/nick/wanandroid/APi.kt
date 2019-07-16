package com.nick.wanandroid

import com.nick.wanandroid.entity.*
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

    @GET("/article/list/{page}/json")
    fun  getArticle(@Path("page") page:Int ) : Call<Result<Article>>

    @GET("/project/tree/json")
    fun  getProjectType( ) : Call<Result<List<ProjectType>>>
    @GET("/project/list/1/json")
    fun  getProject(@Query("cid") cid:Int) : Call<Result<ProjectList>>
    @GET("/tree/json")
    fun  getSystemTree() :Call<Result<List<SystemBean>>>
    @GET("/wxarticle/chapters/json")
    fun  getGongzhong() :Call<Result<List<GongzhonghaoBean>>>

    @GET("/wxarticle/list/{id}/{page}/json")
    fun  getWxArticle(@Path("id") id: Int,@Path("page") page:Int):Call<Result<WxArticle>>
}