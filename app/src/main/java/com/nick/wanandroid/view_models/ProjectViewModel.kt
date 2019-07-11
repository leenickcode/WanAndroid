package com.nick.wanandroid.view_models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nick.wanandroid.entity.ProjectList
import com.nick.wanandroid.entity.ProjectType
import com.nick.wanandroid.entity.Result
import com.nick.wanandroid.models.ProjectModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Administrator on 2019/7/11 0011.
 * @author Administrator
 */
class ProjectViewModel : ViewModel(){
    private val  projectModel:ProjectModel = ProjectModel()
    val  projectList = MutableLiveData<ProjectList>()
    val  projectType = MutableLiveData<List<ProjectType>>()
    fun getProjects(cid: Int): MutableLiveData<ProjectList> {
        projectModel.getProject(cid ,object : Callback<Result<ProjectList>>{
            override fun onFailure(call: Call<Result<ProjectList>>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<Result<ProjectList>>?, response: Response<Result<ProjectList>>?) {
                if (response?.body()?.errorCode== 0 ){
                    projectList.value = response?.body()?.data
                }
            }
        })
        return projectList
    }

    /**
     * 获取项目类别
     */
    fun  getProjectTypes():MutableLiveData<List<ProjectType>>{
        projectModel.getProjectType(object : Callback<Result<List<ProjectType>>>{
            override fun onFailure(call: Call<Result<List<ProjectType>>>?, t: Throwable?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<Result<List<ProjectType>>>?, response: Response<Result<List<ProjectType>>>?) {
                if (response?.body()?.errorCode== 0 ){
                    projectType.value = response?.body()?.data
                }
            }
        })
        return projectType
    }
}