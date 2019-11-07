package com.nick.wanandroid.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @date 2019/11/7 0007
 * @author nick
 * @Description
 */
@Parcelize
 data  class Aaa(    val apkLink: String,
              val author: String,
              val chapterId: Int,
              val chapterName: String,
              val collect: Boolean,
              val courseId: Int) : Parcelable {
}