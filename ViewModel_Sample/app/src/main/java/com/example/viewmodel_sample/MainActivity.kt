package com.example.viewmodel_sample

import android.os.Bundle
import android.widget.TextView
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = MainViewModel()
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.text1).text = updateData(viewModel)
    }

    fun updateData(viewModel: MainViewModel): String {
        val data = viewModel.getPersonList()
        var people = ""
        for (person in data) {
            people += person.name +person.age +person.email +"\n"
        }
        return people
    }
}