package com.nick.wanandroid.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nick.wanandroid.R
import com.nick.wanandroid.entity.WxArticle

/**
 * Created by Administrator on 2019/7/16 0016.
 * @author Administrator
 */
class WxAticleAdapter(val mContext:Context) :RecyclerView.Adapter<WxAticleAdapter.WxViewHolder>() {
      private val TAG  = "WxAticleAdapter"
    var data:MutableList<WxArticle.Data> = mutableListOf()
   set(value) {
        field.clear()
        field.addAll(value)
       notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WxViewHolder {

      return  WxViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_wx_article,parent,false))
    }

    override fun getItemCount(): Int {
        Log.d(TAG, "getItemCount: "+data.size)
       return data.size
    }

    override fun onBindViewHolder(holder: WxViewHolder, position: Int) {
                holder.tvTitle.text = data[position].title
                holder.tvTime. text = data[position].niceDate
    }


    class WxViewHolder(itemView:View) :RecyclerView.ViewHolder(itemView){
            var tvTitle:TextView  = itemView.findViewById(R.id.tv_title)
            var tvTime :TextView = itemView.findViewById(R.id.tv_time)
    }
}