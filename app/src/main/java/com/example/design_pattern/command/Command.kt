package com.example.design_pattern.command

/**
 * 命令者模式
 * 主要是利用高阶函数
 */


typealias command = (worker: Worker) -> Unit

var strCommand: command = {it.addStr('a')}
var numCommand: command = {it.addNum(8)}

class Worker{
    var str = ""
    fun addStr(s: Char){
        str += s
    }
    fun addNum(a: Int){
        str += a
    }
    fun back(){
        str = str.substring(0, str.length - 1)
    }
}

class Client(var worker: Worker){
    var commandList = ArrayList<command>()
    fun execute(com: command){
        com.invoke(worker)
        println("add com")
        commandList.add(com)
        println("commandList size：" + commandList.size)
    }

    fun undo(){
        if (commandList.size == 0)return

        worker.back()

        commandList.remove(commandList[commandList.size - 1])
        println("after undo commandList size：" + commandList.size)

        println("after undo str content：" + show())
    }

    private fun show(): String{
        return worker.str
    }
}

fun main(){
    val client = Client(Worker())
    client.execute(numCommand)
    client.execute(strCommand)
    client.undo()
}