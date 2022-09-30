package com.sebaslogen.kmmapp.android

import android.annotation.SuppressLint
import android.graphics.Color.parseColor
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sebaslogen.kmmapp.MainViewModel
import com.sebaslogen.kmmapp.MyColor

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
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Title(textState)
            Button(viewModel::onChangeButtonPressed) {
                Text("Change my color")
            }
            val color = viewModel.color.collectAsState().value
            Box(
                modifier = Modifier
                    .background(color = Color(parseColor(color)))
                    .height(200.dp)
                    .width(200.dp)
            )
        }
    }

    @Composable
    private fun Title(textState: State<String>) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            textAlign = TextAlign.Center,
            text = textState.value
        )
    }
}
