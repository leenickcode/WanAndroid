package com.nick.wanandroid.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nick.wanandroid.R
import com.nick.wanandroid.entity.SystemBean
import com.nick.wanandroid.views.FlowLayout


/**
 * Created by Administrator on 2019/7/15 0015.
 * @author Administrator
 */
class SystemAdapter(private val mContext: Context) : RecyclerView.Adapter<SystemAdapter.SystemViewHolder>() {

    var data: MutableList<SystemBean> = mutableListOf()
        set(value) {
            field.clear()
            field.addAll(value)
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SystemViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_system, parent, false)
        return SystemViewHolder(view)
    }

    override fun getItemCount(): Int {
       return  data.size
    }

    override fun onBindViewHolder(holder: SystemViewHolder, position: Int) {
        holder.tvType.text = data[position].name
        for (childern in data[position].children){
            val view = TextView(mContext)
            view.text = childern.name
            val marginLayoutParams = ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            )
            marginLayoutParams.setMargins(10, 10, 10, 10)
            view.layoutParams = marginLayoutParams
            holder.flowLayout.addView(view)
        }
    }


    inner class SystemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var flowLayout :FlowLayout = view.findViewById(R.id.flowlayout)
        var tvType :TextView = view.findViewById(R.id.tv_top_class)
    }
}