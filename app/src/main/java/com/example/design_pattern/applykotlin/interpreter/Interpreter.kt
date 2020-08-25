package com.example.design_pattern.applykotlin.interpreter

sealed class Expression{
    abstract fun eval(): Int

    override fun toString(): String = when(this){
        is Add -> "$leftHand + $rightHand"
        is Subtract -> "$leftHand - $rightHand"
        is Number -> "$value"
    }
}

class Add(val leftHand: Expression, val rightHand: Expression): Expression(){
    override fun eval(): Int = leftHand.eval() + rightHand.eval()
}

class Subtract(val leftHand: Expression, val rightHand: Expression): Expression(){
    override fun eval(): Int = leftHand.eval() - rightHand.eval()
}

class Number(val value: Int): Expression(){
    override fun eval(): Int = value
}

fun main() {
    val expression = Add(Number(40), Subtract(Number(10), Number(8)))
    println(expression.toString() + "=" + expression.eval())
}

