package com.example.battery_log_watcher

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class BatteryViewModel(private val dao: BatteryLevelDao) : ViewModel() {
    val batteryLevels = dao.getBatteryLevels()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())
}
