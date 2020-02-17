package com.nick.wanandroid.http

import android.util.Log
import com.nick.wanandroid.APi
import com.nick.wanandroid.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.xml.datatype.DatatypeConstants.SECONDS





/**
 * Created by Administrator on 2019/7/9 0009.
 * @author Administrator
 */
class RetrofitUtil {

   companion object{
       val instance =RetrofitUtilInner.instance

       fun initClient(): OkHttpClient {
//           val logInterceptor = HttpLoggingInterceptor(object  :HttpLoggingInterceptor.Logger{
//               override fun log(message: String) {
//                   Log.d("HttpLogInfo", message);//okHttp的详细日志会打印出来
//               }
//
//           })
//           logInterceptor.level = HttpLoggingInterceptor.Level.BODY
           val builder = OkHttpClient().newBuilder()
//           builder.readTimeout(10, TimeUnit.SECONDS)
//           builder.connectTimeout(9, TimeUnit.SECONDS)

//           if (BuildConfig.DEBUG) {
               val interceptor = HttpLoggingInterceptor()
               interceptor.level = HttpLoggingInterceptor.Level.BODY
               builder.addInterceptor(interceptor)
           builder.addInterceptor(ReceivedCookiesInterceptor())
           builder.addInterceptor(AddCookiesInterceptor())
//           }

           return  builder.build()
       }
   }

    private object  RetrofitUtilInner{
        val instance = Retrofit.Builder().baseUrl(APi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(initClient())
            .build()
    }


}