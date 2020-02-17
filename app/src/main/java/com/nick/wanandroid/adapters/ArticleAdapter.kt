package com.nick.wanandroid.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nick.wanandroid.R
import com.nick.wanandroid.callback_interface.ItemClickListener
import com.nick.wanandroid.entity.ArticleData

/**
 * Created by Administrator on 2019/7/11 0011.
 * @author Administrator
 */
class ArticleAdapter(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var list: List<ArticleData> = listOf()
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
        if (holder is HomeViewHolder) {

            holder.tvTitle?.text = list[position].title
            holder.tvAuth?.text = list[position].author
            holder.tvTime?.text = list[position].niceDate
            holder.tvType?.text = list[position].superChapterName + "/" + list[position].chapterName
            if (list[position].collect) {
                holder.ivCollec.setImageResource(R.drawable.collect_pre)
            } else {
                holder.ivCollec.setImageResource(R.drawable.collect)
            }
            holder.ivCollec.setOnClickListener {
                listener?.onClick(list[position],position,it)
            }
        }
    }

    var listener: ItemClickListener? = null

    inner class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvTitle: TextView? = null
        var tvAuth: TextView? = null
        var tvType: TextView? = null
        var tvTime: TextView? = null
        val ivCollec = view.findViewById<ImageView>(R.id.iv_collect)

        init {
            tvTitle = view.findViewById(R.id.tv_title)
            tvAuth = view.findViewById(R.id.tv_author)
            tvType = view.findViewById(R.id.tv_type)
            tvTime = view.findViewById(R.id.tv_time)

        }
    }
}