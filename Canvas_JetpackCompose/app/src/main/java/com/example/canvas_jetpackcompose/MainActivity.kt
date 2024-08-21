package com.example.canvas_jetpackcompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Colors
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme{
                Greeting()
            }
        }
    }
}

@Composable
fun Greeting() {
    Column {
        Text(
            text = "Canvas Jetpack Compose",
            style = TextStyle(
                color = Color.Black,
                fontSize = 24.sp
            )
        )
    }
    Divider(
        thickness = 2.dp,
        color = Color.Black
    )

    Canvas(modifier = Modifier.fillMaxSize())
    {
        val canvasQuadrantSize = size / 2F
        drawRect(
            color = Color.Magenta,
            size = canvasQuadrantSize
        )
    }

}