package com.nick.wanandroid.ui


import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayout
import com.nick.wanandroid.R
import com.nick.wanandroid.adapters.WxAticleAdapter
import com.nick.wanandroid.entity.WxArticle
import com.nick.wanandroid.view_models.GongzhongViewModel
import kotlinx.android.synthetic.main.fragment_gongzhonghao.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class GongzhonghaoFragment : Fragment() {
    lateinit var viewModel: GongzhongViewModel
      private val TAG  = "GongzhonghaoFragment"
    lateinit var mAdapter : WxAticleAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gongzhonghao, container, false)
    }

    @SuppressLint("WrongConstant")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=ViewModelProviders.of(this)[GongzhongViewModel::class.java]
        viewModel.getGongzhong().observe(this, Observer {
                for(item in it){
                    tab_gongzhong.addTab(tab_gongzhong.newTab().setText(item.name))
                }

        })
        tab_gongzhong.addOnTabSelectedListener(object :
            TabLayout.BaseOnTabSelectedListener<TabLayout.Tab> {
            override fun onTabReselected(p0: TabLayout.Tab?) {
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }
            override fun onTabSelected(p0: TabLayout.Tab?) {
                Log.d(TAG, "onTabSelected: ")
                getArticle(p0!!.position)
            }

        })

        mAdapter = WxAticleAdapter(context!!)
        rv_article.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        rv_article.adapter = mAdapter

    }

    /**
     * 获取公众号下面的文章
     */
    fun getArticle(postion:Int){

        viewModel.wxList.value?.get(postion)?.let { viewModel.getWxArticle(it.id,
            1
            ).observe(this, Observer {
                    mAdapter.data = it?.datas as MutableList<WxArticle.Data>
        }) }
    }
}
