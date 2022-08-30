package com.sebaslogen.kmmapp.android

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sebaslogen.kmmapp.MainViewModel

class MainActivity : ComponentActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                MainScreen()
            }
        }
    }

    @Composable
    private fun MainScreen() {
        val viewModel: MainViewModel = viewModel()
        LaunchedEffect(Unit) {
            viewModel.initialize()
        }
        val textState = viewModel.data.collectAsState()
        title(textState)
    }

    @Composable
    private fun title(textState: State<String>) {
        Text(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentHeight(),
            textAlign = TextAlign.Center,
            text = textState.value
        )
    }
}
