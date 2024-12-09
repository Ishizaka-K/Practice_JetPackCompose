package com.example.battery_log_watcher
import BatteryViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class BatteryViewModelFactory(
    private val dao: BatteryLevelDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BatteryViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return BatteryViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
