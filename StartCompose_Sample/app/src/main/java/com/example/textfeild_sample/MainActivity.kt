package com.example.startcompose_sample

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.provider.FontsContractCompat.Columns
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Lifecycle

class MainActivity : AppCompatActivity() {
    // app gradle に
    // buildFeatures {
    //     compose = true
    // }
    //　とdependenciesを追加することで、Compose を使えるようになる

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // setContent で画面を構築する
            // MaterialTheme は、Material Design のデザインを適用するためのコンポーネント
            // Surface は、Material Design のデザインを適用するためのコンポーネント
            // Text は、テキストを表示するためのコンポーネント
            // Composable は、Compose で画面を構築するためのアノテーション
            // Greeting は、テキストを表示
            MaterialTheme {
                Surface {
                    Greeting("Android")
                    // Your content here
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {

    var name by rememberSaveable { mutableStateOf(name) }

    Column() {
        Text(
            text = "typed: ${name}.",
            style = TextStyle(
                color = androidx.compose.ui.graphics.Color.Red,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
            )
        )
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(name) })

        Button(
            modifier = Modifier.padding(16.dp),
            onClick = { /*TODO*/ }
        ) {
            name = Text(text = "Hello $name!").toString() // ボタンを押すと、Hello Android! と表示される
        }
    }
}