package com.sebaslogen.kmmapp

import co.touchlab.kermit.Logger
import dev.icerock.moko.mvvm.flow.CStateFlow
import dev.icerock.moko.mvvm.flow.cStateFlow
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {
    private val _data: MutableStateFlow<String> = MutableStateFlow("Hola")
    val data: CStateFlow<String> = _data.cStateFlow()

    fun initialize() {
        Logger.d { "MainViewModel Init" }
        viewModelScope.launch {
            val greeting = createGreeting()
            _data.value = "$greeting from StateFlow"
        }
    }

    suspend fun createGreeting(): String {
        var counter = 0
        delay(200)
        counter = 55
        return "Hola, ${Platform().platform}! $counter"
    }

    fun greetingBasicTest() = "Hola basic test"
}