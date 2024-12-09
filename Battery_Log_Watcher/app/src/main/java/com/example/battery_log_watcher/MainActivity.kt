package com.example.battery_log_watcher

import BatteryViewModel
import android.content.Context
import android.os.BatteryManager
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.AlertDialog
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // AppDatabaseインスタンスを取得
        val database = AppDatabase.getInstance(applicationContext)
        val batteryLevelDao = database.batteryLevelDao()

        // ViewModelを作成
        val viewModelFactory = BatteryViewModelFactory(batteryLevelDao)
        val batteryViewModel = ViewModelProvider(this, viewModelFactory)
            .get(BatteryViewModel::class.java)

        setContent {
            BatteryScreen(viewModel = batteryViewModel,this)
        }
        // WorkManagerを使ってBatteryWorkerを1分間隔で実行
        val workRequest: WorkRequest = PeriodicWorkRequestBuilder<BatteryWorker>(10, TimeUnit.SECONDS)
            .build()
        WorkManager.getInstance(this).enqueue(workRequest)
    }


    companion object {
        fun getBatteryLevel(context: Context): Int {
            val batteryManager = context.getSystemService(Context.BATTERY_SERVICE) as BatteryManager
            return batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
        }
    }
}
