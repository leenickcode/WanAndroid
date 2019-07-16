package com.nick.wanandroid.models

import com.nick.wanandroid.APi
import com.nick.wanandroid.entity.GongzhonghaoBean
import com.nick.wanandroid.entity.Result
import com.nick.wanandroid.entity.WxArticle
import com.nick.wanandroid.http.RetrofitUtil
import retrofit2.Callback

/**
 * Created by Administrator on 2019/7/16 0016.
 * @author Administrator
 */
class GongzhongModel {
    fun  getGongzhong(callback: Callback<Result<List<GongzhonghaoBean>>>){

        val retrofit = RetrofitUtil.instance
        val api = retrofit.create(APi::class.java)
        api.getGongzhong().enqueue(callback)
    }

    fun  getWxArticle(
        id:Int,
        page:Int,
        callback: Callback<Result<WxArticle>>
    ){
        val retrofit = RetrofitUtil.instance
        val api = retrofit.create(APi::class.java)
        api.getWxArticle(id,page).enqueue(callback)
    }
}