package com.nick.wanandroid.view_models

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nick.wanandroid.entity.Result
import com.nick.wanandroid.entity.SystemBean
import com.nick.wanandroid.models.SystemMode
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

/**
 * Created by Administrator on 2019/7/15 0015.
 * @author Administrator
 */
class SystemViewModel : ViewModel() {
    val listSystemBean = MutableLiveData<List<SystemBean>>()

    fun getSystemTree() : MutableLiveData<List<SystemBean>> {
        val systemMode = SystemMode()
        viewModelScope.launch {
            try {
                listSystemBean.value = systemMode.getSystemTree().data
            }catch (e: Exception) {
                Log.e("ProjectViewModel", e.message)
            }
        }
        return listSystemBean
    }
}