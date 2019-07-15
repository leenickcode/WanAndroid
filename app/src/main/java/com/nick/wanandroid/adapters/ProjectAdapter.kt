package com.nick.wanandroid.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nick.wanandroid.R
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
      private val TAG  = "ProjectAdapter"
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view: View = LayoutInflater.from(context).inflate(R.layout.item_project, parent, false)
        return HomeViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.d(TAG, "getItemCount: "+list.size)
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            if ( holder is HomeViewHolder){

                holder.tvTitle?.text = list[position].title
                holder.tvAuth?.text = list[position].author

                holder.tvTime?.text = list[position].niceDate
//                holder.tvType?.text =list[position].superChapterName  +"/"+list[position].chapterName
                holder.tvIntro?.text = list[position].desc
            }
    }

    inner class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
         var tvTitle: TextView? = null
         var tvAuth: TextView? = null
         var tvType: TextView? = null
         var tvTime: TextView? = null
        var tvIntro: TextView? = null
        init {
            tvTitle = view.findViewById(R.id.tv_title)
            tvAuth = view.findViewById(R.id.tv_author)
            tvType = view.findViewById(R.id.tv_search)
            tvTime = view.findViewById(R.id.tv_time)
            tvIntro=view.findViewById(R.id.tv_intro)
        }
    }
}