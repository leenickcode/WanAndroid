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
          const val BASE_URL = "https://www.wanandroid.com"
    }
    @FormUrlEncoded
    @POST("/user/login")
    fun  login(@Field("username") name :String, @Field("password") password :String ) : Call<Result<User>>
    @FormUrlEncoded
    @POST("/user/login")
   suspend fun  login2(@Field("username") name :String, @Field("password") password :String ):Result<User>
    /**
     * 获取首页文章
     */
    @GET("/article/list/{page}/json")
   suspend fun  getArticle(@Path("page") page:Int ) : Result<Article>

    @GET("/project/tree/json")
   suspend  fun  getProjectType( ) : Result<List<ProjectType>>
    @GET("/project/list/1/json")
   suspend fun  getProject(@Query("cid") cid:Int) :Result<ProjectList>
    @GET("/tree/json")
   suspend fun  getSystemTree() :Result<List<SystemBean>>
    @GET("/wxarticle/chapters/json")
    fun  getGongzhong() :Call<Result<List<GongzhonghaoBean>>>

    @GET("/wxarticle/list/{id}/{page}/json")
   suspend fun  getWxArticle(@Path("id") id: Int,@Path("page") page:Int):Result<WxArticle>

    /**
     * 收藏站内文章
     */
    @POST("/lg/collect/{id}/json")
     suspend fun collect(@Path("id") id:Int):Result<Any>
}