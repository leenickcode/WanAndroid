package com.nick.wanandroid.entity

/**
 * Created by Administrator on 2019/7/8 0008.
 * @author Administrator
 */
data class User(
    val admin: Boolean,
    val chapterTops: List<Any>,
    val collectIds: List<Any>,
    val email: String,
    val icon: String,
    val id: Int,
    val nickname: String,
    val password: String,
    val token: String,
    val type: Int,
    val username: String
)