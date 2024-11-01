package com.example.battery_log_watcher
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BatteryLevelDao {
    @Insert
    suspend fun insertBatteryLevel(batteryLevel: BatteryLevel)

    @Query("SELECT * FROM battery_level ORDER BY timestamp ASC")
    fun getBatteryLevels(): Flow<List<BatteryLevel>>
}