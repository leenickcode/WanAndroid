package com.nick.wanandroid

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * Created by Administrator on 2019/6/28 0028.
 * @author Administrator
 */
class Test {
    var  a: Int = 3
        get() = 3
        set(value) {
            field = value
        }
}



fun main(args: Array<String>) {
    var job = GlobalScope.launch { // 在后台启动一个新的协程并继续

        for (i in 1000  downTo 1){
            println("这是创建你的第一个协程${Thread.currentThread().name}") // 在延迟后打印输出
        }
    }
    for (i in 1000  downTo 1){
        println("这是主线程${Thread.currentThread().name}") // 协程已在等待时主线程还在继续
    }

    Thread.sleep(2000L) // 阻塞主线程 2 秒钟来保证 JVM 存活

}
class TestCase {

    private val name: Int by lazy { 1 }

    fun printname() {
        println(name)
    }

}



