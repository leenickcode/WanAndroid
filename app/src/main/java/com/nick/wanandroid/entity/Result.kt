package com.nick.wanandroid.entity

/**
 * Created by Administrator on 2019/7/8 0008.
 * @author Administrator
 */
class Result<T> {
    var data : T? = null
    var errorCode: Int = 0
    var errorMsg = ""
}