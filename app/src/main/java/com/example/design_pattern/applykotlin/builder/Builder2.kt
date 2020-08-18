package com.example.design_pattern.applykotlin.builder


data class Bike(var color: String ="red",
                val gears: Int = 3,
                var rack: Boolean = true)


fun main() {
    println("${Bike(color = "yellow", gears = 12, rack = true)}")
}