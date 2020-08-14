package com.example.design_pattern.adapter

/**
 * 适配器模式
 * 目的：就是通过一个类，去拿对方里头的方法
 * 封装一层，间接的去拿要用的东西，自己还可以加一些额外的方法
 *
 */

open class Adaptee{

    fun adapteeRequest(){
        println("被适配者方法")
    }
}

interface Target{
    fun request()
}

class Adapter : Adaptee(), Target{
    override fun request() {
        super.adapteeRequest()
    }

    fun special(){
        println("附加的新增方法哟")
    }
}

class objectAdapter: Target{
    val adaptee = Adaptee()
    override fun request() {
        adaptee.adapteeRequest()
    }
    fun special(){
        println("附加的新增方法哟")
    }
}

fun main (args: Array<String>){
    val adapter = Adapter()
    adapter.request()
    adapter.special()
//    val objectAdapter = objectAdapter()
//    objectAdapter.request()
//    objectAdapter.special()
}