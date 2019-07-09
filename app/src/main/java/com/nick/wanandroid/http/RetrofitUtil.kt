package com.nick.wanandroid.http

import com.nick.wanandroid.APi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Administrator on 2019/7/9 0009.
 * @author Administrator
 */
class RetrofitUtil {

   companion object{
       val instance =RetrofitUtilInner.instance
   }

    private object  RetrofitUtilInner{
        val instance = Retrofit.Builder().baseUrl(APi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}