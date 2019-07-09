package com.nick.wanandroid.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nick.wanandroid.entity.Result
import com.nick.wanandroid.entity.User
import com.nick.wanandroid.models.LoginModel
import retrofit2.Call
import retrofit2.Response

/**
 * Created by Administrator on 2019/7/9 0009.
 * @author Administrator
 */
class LoginViewModel : ViewModel() {

    val  user : MutableLiveData<Result<User>> by lazy {
        MutableLiveData<Result<User>>()
    }
     fun login(username: String, password: String): MutableLiveData<Result<User>> {
            val model = LoginModel()
                model.login( username,password, object : retrofit2.Callback<com.nick.wanandroid.entity.Result<User>>{
                    override fun onFailure(call: Call<Result<User>>?, t: Throwable?) {

                    }

                    override fun onResponse(call: Call<Result<User>>?, response: Response<Result<User>>?) {
                        user.value = response?.body()
                    }

                })
         return user
    }
}