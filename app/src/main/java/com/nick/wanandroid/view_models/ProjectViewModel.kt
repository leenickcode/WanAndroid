package com.nick.wanandroid.view_models

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nick.wanandroid.entity.ProjectList
import com.nick.wanandroid.entity.ProjectType
import com.nick.wanandroid.entity.Result
import com.nick.wanandroid.models.ProjectModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

/**
 * Created by Administrator on 2019/7/11 0011.
 * @author Administrator
 */
class ProjectViewModel : ViewModel() {
    private val projectModel: ProjectModel = ProjectModel()
     val projectList = MutableLiveData<ProjectList>()
     val projectType = MutableLiveData<List<ProjectType>>()
    fun getProjects(cid: Int) {
        viewModelScope.launch {
            try {
                projectList.value = projectModel.getProject(cid).data
            } catch (e: Exception) {
                Log.e("ProjectViewModel", e.message)
            }
        }

    }

    /**
     * 获取项目类别
     */
    fun getProjectTypes() {
        viewModelScope.launch {
            try {
                projectType.value = projectModel.getProjectType()?.data
            } catch (e: Exception) {
                Log.e("ProjectViewModel", e.message)
            }
        }
    }
}