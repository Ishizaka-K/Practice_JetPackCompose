package com.example.battery_log_watcher

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BatteryGraph(batteryLevels: List<BatteryLevel>) {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val maxLevel = 100 // バッテリーの最大値

        batteryLevels.forEachIndexed { index, battery ->
            val barHeight = battery.level / maxLevel.toFloat() * size.height
            val x = index * (size.width / batteryLevels.size)
            drawLine(
                color = Color.Blue,
                start = Offset(x, size.height),
                end = Offset(x, size.height - barHeight),
                strokeWidth = 8f
            )
        }
    }
}
