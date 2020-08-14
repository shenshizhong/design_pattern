package com.example.design_pattern.factory

/**
 * 工厂模式（简单工厂、工厂方法、抽象工厂）
 *
 */

interface Shape{
    fun draw()
}

class Circle: Shape{

    constructor(){
        println("Circle")
    }

    override fun draw() {
        println("draw circle")
    }
}

class Rectangle: Shape{
    override fun draw() {
        println("draw rectangle")
    }
}

class SimpleFactory{
    companion object{
        fun getShape(type: String?): Shape?{
            return when(type){
                "Circle" -> Circle()
                "Rectangle" -> Rectangle()
                else -> null
            }
        }
    }
}

interface Factory{
    fun getShape(): Shape
}

class CircleFactory: Factory{
    override fun getShape(): Shape {
        return Circle()
    }
}

class RectangleFactory: Factory{
    override fun getShape(): Shape {
        return Rectangle()
    }
}

interface Gun{
    fun shooting()
}

interface Bullet{
    fun load()
}

class AK: Gun{
    override fun shooting() {
        println("shooting with AK")
    }
}

class M4A1: Gun{
    override fun shooting() {
        println("shooting with M4A1")
    }
}

class AK_Bullet: Bullet{
    override fun load() {
        println("load bullet with AK")
    }
}

class M4A1_Bullet: Bullet{
    override fun load() {
        println("load bullet with M4A1")
    }
}

interface AbstractFactory{
    fun productGun(): Gun
    fun productBullet(): Bullet
}

class AK_Factory: AbstractFactory{
    override fun productGun(): Gun {
        return AK()
    }

    override fun productBullet(): Bullet {
        return AK_Bullet()
    }
}

class M4A1_Factory: AbstractFactory{
    override fun productGun(): Gun {
        return M4A1()
    }

    override fun productBullet(): Bullet {
        return M4A1_Bullet()
    }

}

fun main(args: Array<String>){
    //简单工厂
//    SimpleFactory.getShape("Circle")?.draw()

    //工厂方法
//    val circleFactory = CircleFactory()
//    circleFactory.getShape().draw()

    AK_Factory().productGun().shooting()
    AK_Factory().productBullet().load()

}

