package com.example.design_pattern.applykotlin.decorator

/**
 * 装饰者模式
 * 不改变原有类的基础上，动态扩展一个对象的功能
 *
 */



interface Text{
    fun draw()
}

class DefaultText(val text: String): Text{
    override fun draw() {
        print(text)
    }

}

fun Text.underline(decorated: Text.() -> Unit){
    print("_")
    this.decorated()
    print("_")
}

fun Text.background(decorated: Text.() -> Unit){
    print("\u001B[43m")
    this.decorated()
    print("\u001B[0m")
}

fun preDecorated(decorated: Text.() -> Unit): Text.() -> Unit{
    return {
        background{
            underline{
                decorated()
            }
        }
    }
}

fun preDecorated2(decorated: Text.() -> Unit): Text.() -> Unit{
    return{
        underline{
            decorated()
        }
    }
}

fun main() {
    DefaultText("Hello").run (preDecorated { draw() })
    DefaultText("World").run (preDecorated2 { draw()})
}