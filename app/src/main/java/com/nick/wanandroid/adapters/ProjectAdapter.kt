package com.nick.wanandroid.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.nick.wanandroid.R
import com.nick.wanandroid.callback_interface.ItemClickListener
import com.nick.wanandroid.entity.Project

/**
 * Created by Administrator on 2019/7/10 0010.
 * @author Administrator
 */
class ProjectAdapter(val context: Context) : RecyclerView.Adapter<ProjectAdapter.HomeViewHolder>() {
    var list: List<Project> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    private val TAG = "ProjectAdapter"
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProjectAdapter.HomeViewHolder {

        val view: View = LayoutInflater.from(context).inflate(R.layout.item_project, parent, false)
        return HomeViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.d(TAG, "getItemCount: " + list.size)
        return list.size
    }

    override fun onBindViewHolder(holder:ProjectAdapter.HomeViewHolder, position: Int) {
            holder.tvTitle.text = list[position].title
            holder.tvAuth.text = list[position].author
            holder.tvTime.text = list[position].niceDate
            holder.tvIntro.text = list[position].desc
            holder.cl_item.setOnClickListener {
                listener?.onClick(list[holder.adapterPosition],holder.adapterPosition,it)
            }
    }

    inner class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvTitle: TextView = view.findViewById(R.id.tv_title)
        var tvAuth: TextView = view.findViewById(R.id.tv_author)
        //         var tvType: TextView? = view.findViewById(R.id.tv_search)
        var tvTime: TextView = view.findViewById(R.id.tv_time)
        var tvIntro: TextView = view.findViewById(R.id.tv_intro)
        val cl_item: ConstraintLayout = view.findViewById(R.id.cl_item)

    }
    public var listener: ItemClickListener? = null
}