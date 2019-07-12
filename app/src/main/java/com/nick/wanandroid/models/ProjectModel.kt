package com.nick.wanandroid.models

import com.nick.wanandroid.APi
import com.nick.wanandroid.entity.ProjectList
import com.nick.wanandroid.entity.ProjectType
import com.nick.wanandroid.entity.Result
import com.nick.wanandroid.entity.User
import com.nick.wanandroid.http.RetrofitUtil
import retrofit2.Call
import retrofit2.Callback

/**
 * Created by Administrator on 2019/7/11 0011.
 * @author Administrator
 */
class ProjectModel {

    /**
     * 获取 项目分类
     */
    fun getProjectType(callback: Callback<Result<List<ProjectType>>>): Unit {
        val retrofit =  RetrofitUtil.instance
        val  aPi = retrofit.create(APi::class.java)
        val call : Call<Result<List<ProjectType>>> = aPi.getProjectType()
        //使用对象表达式来创建匿名内部类
        call.enqueue(callback)
    }

    /**
     * 获取项目列表
     * @param cid 项目类别
     */
    fun getProject(cid : Int,callback: Callback<Result<ProjectList>>){
        val retrofit =  RetrofitUtil.instance
        val  aPi = retrofit.create(APi::class.java)
        val call : Call<Result<ProjectList>> = aPi.getProject(cid)
        //使用对象表达式来创建匿名内部类
        call.enqueue(callback)

    }
}