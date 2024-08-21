package com.example.darktheme_add

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //MODE_NIGHT_FOLLOW_SYSTEM システムの設定に従う
        //MODE_NIGHT_NO.  昼間モードテーマ
        //MODE_NIGHT_YES.　 夜間モードテーマ

        AppCompatDelegate.setDefaultNightMode( MODE_NIGHT_NO )

        //res下のvalues-nightフォルダにあるnight_theme.xmlを読み込む
        //AppCompatDelegate.setDefaultNightMode( MODE_NIGHT_YES )
        //フォルダの表示をProjectにして表示
        //ManifestのThemeをとvalueのnameを合わせる

        setContentView(R.layout.activity_main)

    }
}