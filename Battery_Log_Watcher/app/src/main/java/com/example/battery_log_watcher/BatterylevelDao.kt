package com.example.battery_log_watcher
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BatteryLevelDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBatteryLevel(batteryLevel: BatteryLevel)

    @Query("SELECT * FROM battery_levels ORDER BY timestamp DESC")
    fun getAllBatteryLevels(): Flow<List<BatteryLevel>>
}