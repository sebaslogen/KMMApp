package com.sebaslogen.kmmapp

import co.touchlab.kermit.Logger
import dev.icerock.moko.mvvm.flow.CFlow
import dev.icerock.moko.mvvm.flow.CStateFlow
import dev.icerock.moko.mvvm.flow.cFlow
import dev.icerock.moko.mvvm.flow.cStateFlow
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlin.random.Random


class MainViewModel : ViewModel() {
    private val _data: MutableStateFlow<String> = MutableStateFlow("Hola")
    val data: CStateFlow<String> = _data.cStateFlow()
    private val _color: MutableStateFlow<MyColor> = MutableStateFlow(MyColor.Red)
    val color: CStateFlow<String> = _color.map(viewModelScope) {it.hexColor}.cStateFlow()

    fun initialize() {
        Logger.d { "MainViewModel Init" }
        viewModelScope.launch {
            val greeting = createGreeting()
            _data.value = "$greeting from StateFlow"
        }
    }

    private suspend fun createGreeting(): String {
        delay(200)
        return "Hola, ${Platform().platform}! Delayed"
    }

    fun onChangeButtonPressed() {
        val newColor = MyColor.values()[Random.nextInt(MyColor.values().size)]
        _color.value = newColor
    }
}