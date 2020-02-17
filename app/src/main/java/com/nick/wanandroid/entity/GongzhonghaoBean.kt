package com.nick.wanandroid.entity

/**
 * Created by Administrator on 2019/7/16 0016.
 * @author Administrator
 * 公众号
 */
data class GongzhonghaoBean(
    val children: List<Any>,
    val courseId: Int,
    val id: Int,
    val name: String,
    val order: Int,
    val parentChapterId: Int,
    val userControlSetTop: Boolean,
    val visible: Int
)