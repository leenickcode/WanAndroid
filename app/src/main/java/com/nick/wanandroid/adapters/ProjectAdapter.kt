package com.nick.wanandroid.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nick.wanandroid.R
import com.nick.wanandroid.entity.ArticleData
import com.nick.wanandroid.entity.Project

/**
 * Created by Administrator on 2019/7/10 0010.
 * @author Administrator
 */
class ProjectAdapter(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var list: List<Project> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view: View = LayoutInflater.from(context).inflate(R.layout.item_wenzhang, parent, false)
        return HomeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            if ( holder is HomeViewHolder){

                holder.tvTitle?.text = list[position].title
                holder.tvAuth?.text = list[position].author
                holder.tvTime?.text = list[position].niceDate
                holder.tvType?.text =list[position].superChapterName  +"/"+list[position].chapterName
            }
    }

    inner class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
         var tvTitle: TextView? = null
         var tvAuth: TextView? = null
         var tvType: TextView? = null
         var tvTime: TextView? = null

        init {
            tvTitle = view.findViewById(R.id.tv_title)
            tvAuth = view.findViewById(R.id.tv_auth)
            tvType = view.findViewById(R.id.tv_type)
            tvTime = view.findViewById(R.id.tv_time)

        }
    }
}