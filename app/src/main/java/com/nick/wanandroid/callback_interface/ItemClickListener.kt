package com.nick.wanandroid.callback_interface

import android.view.View

/**
 * @date 2019/10/30 0030
 * @author nick
 * @Description
 */
interface ItemClickListener  {
    fun  onClick(any: Any,position:Int,view: View)
}