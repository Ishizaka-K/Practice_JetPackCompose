package com.example.battery_log_watcher

import BatteryViewModel
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun BatteryScreen(viewModel: BatteryViewModel,context: Context) {
    val batteryLevels = viewModel.batteryLevels.collectAsState(initial = emptyList())
    Column(
        modifier = Modifier.fillMaxSize()
            .background(color = Color.White),
    ){
        Text("Battery Level Over Time")
        //BatteryGraph(batteryLevels = batteryLevels.value)
        Button(onClick = {
            val batteryLevel = MainActivity.getBatteryLevel(context)
            viewModel.logBatteryLevel(batteryLevel)
        }) {
            Text("記録する")
        }

        // 記録されたバッテリーのログを表示
        batteryLevels.value.forEach { log ->
            Text("時刻: ${log.timestamp}, 残量: ${log.level}%")
        }
    }
}

