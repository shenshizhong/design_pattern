package com.example.design_pattern.proxy

import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy
import java.util.*


interface Flyable{
    fun fly()
}

class Bird: Flyable{
    override fun fly() {
        println("Bird is flying...")
        Thread.sleep(Random().nextInt(1000).toLong())
    }
}

class BirdTimeProxy: Flyable{
    var flyable: Flyable? = null
    constructor(flyable: Flyable){
        this.flyable = flyable
    }
    override fun fly() {
        val start = System.currentTimeMillis()
        println("Start flying...")
        this.flyable?.fly()
        val end = System.currentTimeMillis()
        println("end flying...")
        println("Fly time = ${end - start}")
    }

}


fun main(args: Array<String>) {
    //静态代理
//    val birdTimeProxy = BirdTimeProxy(Bird())
//    birdTimeProxy.fly()


    //动态代理
    val handler =
        InvocationHandler { proxy, method, args ->
            if (method.name == "fly") {
                println("haha")
            }
            null
        }

    val bird = Proxy.newProxyInstance(
        Flyable::class.java.classLoader, arrayOf<Class<*>>(
            Flyable::class.java
        ), handler
    ) as Flyable

    bird.fly()


    //更好的理解动态代理，看这个链接
    // https://www.liaoxuefeng.com/wiki/1252599548343744/1264804593397984
}

