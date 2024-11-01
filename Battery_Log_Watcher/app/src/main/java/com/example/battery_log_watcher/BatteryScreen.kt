package com.example.battery_log_watcher

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState


@Composable
fun BatteryScreen(viewModel: BatteryViewModel) {
    val batteryLevels = viewModel.batteryLevels.collectAsState(initial = emptyList())
    Column {
        Text("Battery Level Over Time")
        BatteryGraph(batteryLevels = batteryLevels.value)
    }
}
