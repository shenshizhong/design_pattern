package com.example.design_pattern.applykotlin.builder

/**
 * 建造者模式
 * 一步步构造最终的对象
 */


class Car(){
    var color = "red"
    var doors = 3

    override fun toString(): String = "$color car wiht $doors doors"

}

fun main() {
    Car().apply {
        color = "yellow"
        doors = 4
    }.let {
        println("${it}")
    }
}