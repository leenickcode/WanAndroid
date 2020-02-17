package com.nick.wanandroid.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nick.wanandroid.R
import com.nick.wanandroid.adapters.ProjectAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Main2Activity : AppCompatActivity(),CoroutineScope by CoroutineScope(Dispatchers.Default)  {
    internal var projectAdapter: ProjectAdapter? = null
    var aaa="aaa".also (::println)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
  launch {

  }
//        startActivity()
    }
}

