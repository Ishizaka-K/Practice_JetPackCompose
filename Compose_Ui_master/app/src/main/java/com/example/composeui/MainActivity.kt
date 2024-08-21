package com.example.composeui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContent{
           MaterialTheme{
               Greeting()
           }
       }
    }
}

@Composable
fun Greeting() {
    var counts by rememberSaveable { mutableStateOf(0) }
    var dlog by rememberSaveable { mutableStateOf(false) }
    var message by rememberSaveable { mutableStateOf("This is alert Dialog") }
    Column {
        Box(
            Modifier.clickable (
                onClick = {counts++},
                enabled = true
            ),
            content = {
                Text(
                    text = "Count Button Tapped:"  + counts,
                    style = TextStyle(
                        fontSize = 24.sp,
                        color = MaterialTheme.colors.primary
                        )
                )
            }
        )
        // 仕切り
        Divider(thickness = 10.dp)
        Box(
            Modifier.clickable (
                onClick = {
                    var total = 0
                    for (i in 1..counts) {
                        total += i
                    }
                    message = "Total Button Tapped:" + total
                },
            ),
            content = {
                Text(
                    text = message,
                    style = TextStyle(
                        fontSize = 24.sp,
                        color = MaterialTheme.colors.primary
                        )
                )
            }
        )
    }


}