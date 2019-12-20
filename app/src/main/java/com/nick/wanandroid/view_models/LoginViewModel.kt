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
        val model = LoginModel()
        viewModelScope.launch {
            try {
                user.value = model.login(username, passwrod)
//                 Log.d(TAG, "login2: ${Thread.currentThread().name}")
            } catch (e: Exception) {
                Log.e(TAG, "login2: ${e.message}")
            }

        }
        return user
    }


}