package com.example.design_pattern.facade

/**
 * 外观模式（门面模式）
 * 让子系统更好管理，更加好用
 */

class ComplexSystemStore(private val filePath: String){
    init {
        println("Reading data from file: $filePath")
    }
    private val store = HashMap<String, String>()

    fun store(key: String, payload: String){
        store[key] = payload
    }

    fun read(key: String): String = store[key] ?: ""

    fun commit() = println("Storing cached data:$store to file $filePath")
}

data class User(val login: String)

//充当门面的，通过他去对接内部的子系统，使得子系统更容易被使用
class UserRepository{
    private val complexSystemStore = ComplexSystemStore("/data/android")

    fun save(user: User){
        complexSystemStore.store("user_key", user.login)
        complexSystemStore.commit()
    }


    fun findFirst(): User =  User(complexSystemStore.read("user_key"))
}

fun main() {
    val userRepository = UserRepository()
    val user = User("ssz")
    userRepository.save(user)
    val findFirst = userRepository.findFirst()

    println("Found stored user: $findFirst")
}
