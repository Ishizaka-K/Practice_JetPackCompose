import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.battery_log_watcher.BatteryLevel
import com.example.battery_log_watcher.BatteryLevelDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class BatteryViewModel(private val batteryLevelDao: BatteryLevelDao) : ViewModel() {
    val batteryLevels: Flow<List<BatteryLevel>> = batteryLevelDao.getAllBatteryLevels()

    fun logBatteryLevel(level: Int) {
        val currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))
        viewModelScope.launch {
            batteryLevelDao.insertBatteryLevel(BatteryLevel(level = level, timestamp = currentTime))
        }
    }

    // バッテリーデータを全削除する関数
    fun clearBatteryData() {
        viewModelScope.launch {
            batteryLevelDao.clearAllBatteryLevels()
        }
    }
}
