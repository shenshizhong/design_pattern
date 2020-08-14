package com.example.design_pattern.bridge

/**
 * 桥接模式
 * 可以看成是功能代理实现，新增功能可以和原本实现解耦
 *
 */

interface Student{
    fun study()
    fun sleep()
}

class ChinaStudent: Student{
    override fun study() {
        println("非常努力学习")
    }

    override fun sleep() {
        println("没有时间休息")
    }
}

//最基本的活动"代理"了学生的功能
open class Activities(private var student: Student){
    fun study(){
        student.study()
    }

    fun sleep(){
        student.sleep()
    }
}

//活动的功能扩展在另外一个类中
//扩展功能不涉及学生的类，达到耦合的目的
class  ExActivity(private var student: Student): Activities(student){
    //新增功能
    fun exActivity(){
        if (student is ChinaStudent){

            println("中国学生太累了，不参加活动了")

        }
    }
}

fun main() {
    ExActivity(ChinaStudent()).exActivity()
    Activities(ChinaStudent()).study()
}

