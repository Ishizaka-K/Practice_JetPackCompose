package com.example.battery_log_watcher

import BatteryViewModel
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun BatteryScreen(viewModel: BatteryViewModel,context: Context) {
    val batteryLevels = viewModel.batteryLevels.collectAsState(initial = emptyList())
    Column(
        modifier = Modifier.fillMaxSize()
            .background(color = Color.White),
    ){
        Text("Battery Level Over Time")
        Row (modifier = Modifier.width(250.dp),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween)
        {
            Button(onClick = {
                val batteryLevel = MainActivity.getBatteryLevel(context)
                viewModel.logBatteryLevel(batteryLevel)
            }) {
                Text("記録する")
            }
            Button(onClick = {
                viewModel.clearBatteryData()
            }) {
                Text("Clear")
            }
        }
        //BatteryGraph(batteryLevels = batteryLevels.value)

        // 記録されたバッテリーのログを表示
        batteryLevels.value.forEach { log ->
            Text("時刻: ${log.timestamp}, 残量: ${log.level}%")
        }
    }
}

