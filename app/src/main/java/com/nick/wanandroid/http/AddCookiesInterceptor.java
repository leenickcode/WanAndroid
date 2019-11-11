package com.nick.wanandroid.http;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.nick.wanandroid.app.MyApplication;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author nick
 * @date 2019/11/11 0011
 * @Description
 */
public class AddCookiesInterceptor implements Interceptor {
    private static final String TAG = "AddCookiesInterceptor";

    @Override
    public Response intercept(Chain chain) throws IOException {

        final Request.Builder builder = chain.request().newBuilder();
        SharedPreferences sharedPreferences = MyApplication.getInstance().getSharedPreferences("cookie", Context.MODE_PRIVATE);
        Log.d(TAG, "intercept: " + sharedPreferences.getString("cookie", ""));
        builder.addHeader("Cookie", sharedPreferences.getString("cookie", ""));
        return chain.proceed(builder.build());
    }
}