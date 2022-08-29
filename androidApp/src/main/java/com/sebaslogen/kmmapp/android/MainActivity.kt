package com.sebaslogen.kmmapp.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sebaslogen.kmmapp.Greeter
import android.widget.TextView

fun greet(): String {
    return Greeter().greeting()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = greet()
    }
}
