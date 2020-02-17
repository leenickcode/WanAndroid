package com.nick.wanandroid.http;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.nick.wanandroid.app.MyApplication;

import java.io.IOException;


import okhttp3.Interceptor;
import okhttp3.Response;


/**
 * @author nick
 * @date 2019/11/11 0011
 * @Description
 */
public class ReceivedCookiesInterceptor implements Interceptor {
    private static final String TAG = "ReceivedCookiesIntercep";

    @Override
    public Response intercept(Chain chain) throws IOException {

        Response originalResponse = chain.proceed(chain.request());
        //这里获取请求返回的cookie
        //解析Cookie
        for (String header : originalResponse.headers("Set-Cookie")) {
            if(header.contains("JSESSIONID")){
                SharedPreferences sharedPreferences = MyApplication.getInstance().getSharedPreferences("cookie", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("cookie", header.substring(header.indexOf("JSESSIONID"), header.indexOf(";")));
                editor.commit();
            }
        }
        return originalResponse;
    }
}