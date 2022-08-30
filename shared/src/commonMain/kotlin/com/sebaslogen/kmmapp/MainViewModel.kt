package com.sebaslogen.kmmapp

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {
    private val _data: MutableStateFlow<String> = MutableStateFlow("Hola")
    val data: StateFlow<String> = _data

    fun initialize() {
        viewModelScope.launch {
            val greeting = createGreeting()
            _data.value = greeting
        }
    }

    suspend fun createGreeting(): String {
        var counter = 0
        delay(200)
        counter = 55
        return "Hola, ${Platform().platform}! $counter"
    }
}