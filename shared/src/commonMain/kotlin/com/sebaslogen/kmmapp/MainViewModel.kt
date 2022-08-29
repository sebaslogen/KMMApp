package com.sebaslogen.kmmapp

import dev.icerock.moko.mvvm.viewmodel.ViewModel


class MainViewModel : ViewModel() {
    val id = 321
    fun greeting(): String = id.toString()
}