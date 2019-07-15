package com.nick.wanandroid.view_models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nick.wanandroid.entity.Result
import com.nick.wanandroid.entity.SystemBean
import com.nick.wanandroid.models.SystemMode
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Administrator on 2019/7/15 0015.
 * @author Administrator
 */
class SystemViewModel : ViewModel() {
    val listSystemBean = MutableLiveData<List<SystemBean>>()

    fun getSystemTree() : MutableLiveData<List<SystemBean>> {
        val systemMode = SystemMode()
        systemMode.getSystemTree(object : Callback<Result<List<SystemBean>>> {
            override fun onResponse(call: Call<Result<List<SystemBean>>>?,
                response: Response<Result<List<SystemBean>>>?) {
               if (response?.body()?.errorCode == 0 ){
                   listSystemBean.value = response.body()?.data
               }
            }

            override fun onFailure(call: Call<Result<List<SystemBean>>>?, t: Throwable?) {

            }

        })
        return listSystemBean
    }
}