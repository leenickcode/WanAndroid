package com.nick.wanandroid.view_models

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nick.wanandroid.entity.GongzhonghaoBean
import com.nick.wanandroid.entity.Result
import com.nick.wanandroid.entity.WxArticle
import com.nick.wanandroid.models.GongzhongModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

/**
 * Created by Administrator on 2019/7/16 0016.
 * @author Administrator
 */
class GongzhongViewModel : ViewModel() {
      private val TAG  = "GongzhongViewModel"
    val gongzhongModel = GongzhongModel()
    /**
     * 公众号
     */
    val wxList: MutableLiveData<List<GongzhonghaoBean>> = MutableLiveData<List<GongzhonghaoBean>>()
    /**
     * 文章
     */
    val articles : MutableLiveData<WxArticle> = MutableLiveData()
    fun getGongzhong(): MutableLiveData<List<GongzhonghaoBean>>{
        gongzhongModel.getGongzhong(object : Callback<Result<List<GongzhonghaoBean>>> {
            override fun onResponse(
                call: Call<Result<List<GongzhonghaoBean>>>?,
                response: Response<Result<List<GongzhonghaoBean>>>?) {
               wxList.value = response?.body()?.data
            }

            override fun onFailure(call: Call<Result<List<GongzhonghaoBean>>>?, t: Throwable?) {

            }
        }
        )
        return wxList
    }

    /**
     * 获取公众号下的文章
     */
    fun  getWxArticle(id:Int,page:Int) :MutableLiveData<WxArticle>{
        viewModelScope.launch {
            try {
                articles.value = gongzhongModel.getWxArticle(id,page).data
            }catch (e :Exception){
                Log.e("GongzhongViewModel",e.message)
            }
        }
        return articles
    }
}