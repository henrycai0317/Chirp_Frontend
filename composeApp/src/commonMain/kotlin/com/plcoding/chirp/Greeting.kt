package com.plcoding.chirp

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return sayHello(platform.name)
    }
}

fun sayHello(to: String): String =
    "Hello, $to!"
