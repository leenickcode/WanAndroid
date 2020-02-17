package com.nick.wanandroid.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView
import com.nick.wanandroid.R
import com.nick.wanandroid.entity.SystemBean
import com.nick.wanandroid.views.FlowLayout
import com.nick.wanandroid.views.FrameTextView


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
        return data.size
    }

    override fun onBindViewHolder(holder: SystemViewHolder, position: Int) {
        holder.tvType.text = data[position].name
        holder.flowLayout.removeAllViews()
        for (childern in data[position].children) {
            val view = FrameTextView(mContext)
            view.text = childern.name
            view.initFrame(
                ContextCompat.getColor(mContext, R.color.black)
                , ContextCompat.getColor(mContext, R.color.gray91)
                , ContextCompat.getColor(mContext, R.color.CornflowerBlue)
                , ContextCompat.getColor(mContext, R.color.CornflowerBlue)
                , ContextCompat.getColor(mContext, R.color.gray91)
                , ContextCompat.getColor(mContext, R.color.CornflowerBlue)
                , 2, 5, true, false
            )
            view.setPadding(10,10,10,10)
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
        var flowLayout: FlowLayout = view.findViewById(R.id.flowlayout)
        var tvType: TextView = view.findViewById(R.id.tv_top_class)
    }
}