package com.example.viewbindingsample

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.viewbindingsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var count = 0
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val text1 = binding.textView
        text1.text = "Hello, World!"
        val button1 = binding.button
        button1.setOnClickListener {
            count++
            text1.text = "Clicked $count times"
        }
    }
}