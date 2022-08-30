package com.sebaslogen.kmmapp.android

import android.annotation.SuppressLint
import android.os.Bundle
import com.sebaslogen.kmmapp.Greeter
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import com.sebaslogen.kmmapp.MainViewModel

fun greet(): String {
    return Greeter().greeting()
}

class MainActivity : ComponentActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val vm = MainViewModel()

        setContent {
            MaterialTheme {
//                Box(modifier = Modifier.fillMaxSize()) {

                Text(modifier = Modifier.fillMaxSize().wrapContentHeight(),
                    textAlign = TextAlign.Center,
                    text = "${greet()} ${vm.id}")
//                }
            }
        }

//        setContentView(R.layout.activity_main)
//
//
//        val tv: TextView = findViewById(R.id.text_view)
//        tv.text = "${greet()} ${vm.id}"
    }
}
