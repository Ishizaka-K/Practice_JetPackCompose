package com.example.viewmodel_sample

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = MainViewModel()
        var text = viewModel.getPersonList().toString()
        setContent {
            MainScreen()
        }

    }
}
@Composable
fun MainScreen() {
    Text(text = "Hello, World!")}
}