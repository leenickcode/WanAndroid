package com.nick.wanandroid.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.nick.wanandroid.ui.ArticleFragment
import com.nick.wanandroid.ui.ProjectFragment

/**
 * Created by Administrator on 2019/7/11 0011.
 * @author Administrator
 */
class HomePageAdapter (fm:FragmentManager):FragmentPagerAdapter(fm) {
    val  list:List<Fragment> = listOf(ArticleFragment(),ProjectFragment())
    val titles = listOf("最新博文","最新项目")
    override fun getItem(position: Int): Fragment {
           return list[position]
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position]
    }
}