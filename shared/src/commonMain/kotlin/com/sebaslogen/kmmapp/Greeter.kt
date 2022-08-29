package com.sebaslogen.kmmapp

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class Greeter {
    fun greeting(): String {
        var counter = 0
        runBlocking {
            launch {
                delay(200)
                counter = 55
            }
        }
        return "Hola, ${Platform().platform}! $counter"
    }
}