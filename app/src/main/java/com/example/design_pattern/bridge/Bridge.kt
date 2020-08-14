package com.example.design_pattern.bridge

/**
 * 桥接模式
 * 多角度独立出来，减少他们的耦合
 */

abstract class Implementor{
    abstract fun operation()
}

class ConcreteImplementorA: Implementor(){
    override fun operation() {
        println("具体实现A中的方法")
    }

}

class ConcreteImplementorB: Implementor(){
    override fun operation() {
        println("具体实现B中的方法")

    }

}

open class Abstract{
    lateinit var implementor: Implementor
    open fun operation(){
        if (this::implementor.isInitialized){
            implementor.operation()
        }
    }
}

class RefinedAbstact: Abstract(){
   override fun operation(){
        implementor.operation()
    }
}

fun main() {
    val refinedAbstact = RefinedAbstact()
    refinedAbstact.implementor = ConcreteImplementorA()
    refinedAbstact.operation()

    refinedAbstact.implementor = ConcreteImplementorB()
    refinedAbstact.operation()
}