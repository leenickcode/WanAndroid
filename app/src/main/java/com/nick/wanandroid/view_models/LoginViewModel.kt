package com.nick.wanandroid.view_models

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nick.wanandroid.APi
import com.nick.wanandroid.entity.Result
import com.nick.wanandroid.entity.User
import com.nick.wanandroid.http.RetrofitUtil
import com.nick.wanandroid.models.LoginModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import java.io.IOException

/**
 * Created by Administrator on 2019/7/9 0009.
 * @author Administrator
 */
class LoginViewModel : ViewModel() {
    var loginstate = false
    private val TAG = "LoginViewModel"
    val user: MutableLiveData<Result<User>> by lazy {
        MutableLiveData<Result<User>>()
    }

    fun login(username: String, passwrod: String): MutableLiveData<Result<User>> {
        val retrofit = RetrofitUtil.instance
        val aPi = retrofit.create(APi::class.java)
        viewModelScope.launch {
            Log.d(TAG, "login2: ${Thread.currentThread().name}")
            try {
                val result = aPi.login2(username, passwrod)
                user.value = result
//                 Log.d(TAG, "login2: ${Thread.currentThread().name}")
            } catch (e: Exception) {
                // An exception was thrown when calling the API so we're converting this to an IOException
                Log.e(TAG, "login2: ${e.message}")
            }

        }
        return user
    }


}