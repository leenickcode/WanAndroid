package com.nick.wanandroid.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.nick.wanandroid.R
import kotlinx.android.synthetic.main.fragment_blog_detail.*

/**
 * @date 2019/10/30 0030
 * @author nick
 * @Description
 */
class BlogDetailFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       val project = BlogDetailFragmentArgs.fromBundle(arguments!!)
        wv_blog.webViewClient = WebViewClient()
        //方式一：加载一个网页

        wv_blog.loadUrl(project.project.link)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_blog_detail, container, false)
    }


}