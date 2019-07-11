package com.nick.wanandroid.entity

/**
 * Created by Administrator on 2019/7/11 0011.
 * @author Administrator
 */
data class ProjectType(
    val children: List<Any>,
    val courseId: Int,
    val id: Int,
    val name: String,
    val order: Int,
    val parentChapterId: Int,
    val visible: Int
)