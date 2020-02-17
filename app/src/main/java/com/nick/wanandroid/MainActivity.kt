package com.nick.wanandroid

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.NavAction
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.setupWithNavController(Navigation.findNavController(this, R.id.fragment))
        Navigation.findNavController(this, R.id.fragment)
            .addOnDestinationChangedListener { controller, destination, arguments ->
                //通过该监听控制导航栏的显示隐藏
                when (destination.id) {
                    R.id.homeFragment, R.id.systemFragment, R.id.gongzhonghaoFragment
                        , R.id.myFragment -> {
                        bottomNav.visibility = View.VISIBLE
                    }
                    else -> {
                        bottomNav.visibility = View.GONE
                    }
                }
            }
    }
}
