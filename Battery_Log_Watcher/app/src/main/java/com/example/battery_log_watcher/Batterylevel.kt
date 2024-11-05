package com.example.battery_log_watcher
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "battery_levels")
data class BatteryLevel(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val level: Int,
    val timestamp: String
)