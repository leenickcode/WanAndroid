package com.nick.wanandroid.models

import android.util.Log
import com.nick.wanandroid.APi
import com.nick.wanandroid.entity.Result
import com.nick.wanandroid.entity.User
import com.nick.wanandroid.http.RetrofitUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Administrator on 2019/7/9 0009.
 *
 * @author Administrator
 */
class LoginModel{

    fun login(username:String , passwrod :String ,callback: Callback<Result<User>>): Unit {

        val retrofit =  RetrofitUtil.instance
        val  aPi = retrofit.create(APi::class.java)
        val call : Call<Result<User>> = aPi.login(username,passwrod)
        //使用对象表达式来创建匿名内部类
        call.enqueue(callback)

    }
}
