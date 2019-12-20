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
 suspend  fun getProjectType():  Result<List<ProjectType>> {
        val retrofit =  RetrofitUtil.instance
        val  aPi = retrofit.create(APi::class.java)
        return  aPi.getProjectType()
    }

    /**
     * 获取项目列表
     * @param cid 项目类别
     */
   suspend fun getProject(cid : Int):Result<ProjectList>{
        val retrofit =  RetrofitUtil.instance
        val  aPi = retrofit.create(APi::class.java)
        return aPi.getProject(cid)
    }
}