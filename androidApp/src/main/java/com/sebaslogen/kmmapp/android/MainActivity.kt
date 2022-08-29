package com.sebaslogen.kmmapp.android

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sebaslogen.kmmapp.Greeter
import android.widget.TextView
import com.sebaslogen.kmmapp.MainViewModel

fun greet(): String {
    return Greeter().greeting()
}

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vm = MainViewModel()

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = "${greet()} ${vm.id}"
    }
}
