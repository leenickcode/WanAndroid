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
fun  Test.call(){
    println("动1动1，收到回复")
}




fun main(args: Array<String>) {

    val over:Shape = Shape.ovel
    println(    over.name
    )
    println(    over.declaringClass
    )
    println(    over.compareTo(Shape.rectangle)
    )
}

fun add(): Unit {
    do {

    }while (true)
}

enum class Color{
    RED,BLACK,BLUE,GREEN,WHITE,Yellow
}
enum class Shape(value:Int){
    ovel(100),
    rectangle(200)
}
// 创建接口
interface Base {
    fun print()
}

// 实现此接口的被委托的类
class BaseImpl(val x: Int) : Base {
    override fun print() { print(x) }
}

