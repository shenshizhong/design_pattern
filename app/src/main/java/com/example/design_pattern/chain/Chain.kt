package com.example.design_pattern.chain

/**
 * 责任链模式
 * 超出责任范围，指定下一个负责人处理
 */

data class Request(val leaveDay: Int, val msg: String)

open class Handler(val name: String, val leaveLimit: Int){
    var next: Handler? = null

    open fun handRequest(request: Request){
        if (request.leaveDay <= leaveLimit){
            println("${request.msg}请假， $name 批准了")
        }else{
            println("$name:超过${leaveLimit}天，让领导处理")
            next?.handRequest(request)
        }

    }

}

//可以根据需求，扩展Handler
class FinalHandler(name: String): Handler(name, Int.MAX_VALUE){
    override fun handRequest(request: Request) {
        println("$name,${request.msg} -> 找财务领下工资，game over")
    }
}

fun main() {
    val leader = Handler("直接上级", 1)
    val manager = Handler("管理者", 30)
    val generalManager = Handler("总经理", 365)
    val boss = FinalHandler("老板")

    leader.next = manager
    manager.next = generalManager
    generalManager.next = boss

    leader.handRequest(Request(1,"头疼脑热"))
    println("--------------------------")
    leader.handRequest(Request(14,"老婆生孩子"))
    println("--------------------------")
    leader.handRequest(Request(365,"世界那么大，我想出去看看"))
    println("--------------------------")
    leader.handRequest(Request(3650,"不想上了"))


}