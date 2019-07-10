package com.nick.wanandroid

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


}
class TestCase {

    private val name: Int by lazy { 1 }

    fun printname() {
        println(name)
    }

}



