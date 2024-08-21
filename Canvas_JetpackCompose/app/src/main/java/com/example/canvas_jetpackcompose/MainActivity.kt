package com.example.canvas_jetpackcompose

import android.graphics.RectF
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme{
                Greeting()
            }
        }
    }
}

@Composable
fun Greeting() {
    Column {
        Text(
            text = "Canvas Jetpack Compose",
            style = TextStyle(
                color = Color.Black,
                fontSize = 24.sp
            )
        )
    }
    Divider(
        thickness = 2.dp,
        color = Color.Black
    )

    Canvas(modifier = Modifier.fillMaxSize())
    {
        val canvasQuadrantSize = size / 2F
        val rectf = Size(100f, 100f)
        // □ 四角形を描画
        drawRect(
            color = Color.Magenta,
            size = canvasQuadrantSize,//四角形のサイズ
            topLeft = Offset(
                x = canvasQuadrantSize.width/4,
                y = canvasQuadrantSize.height/4
            )//四角形の左上の座標
        )

        // □　角が丸い四角形を描画
        drawRoundRect(
            color = Color.Blue,
            size = canvasQuadrantSize,//四角形のサイズ
            topLeft = Offset(
                x = canvasQuadrantSize.width,
                y = 100f
            ),//四角形の左上の座標
            cornerRadius = CornerRadius(100F,400F)// 角の丸み
        )

        // 〇 円を描画
        drawCircle(
            color = Color.Yellow,
            radius = 50F,//半径
            center = Offset(
                x = canvasQuadrantSize.width,
                y = canvasQuadrantSize.height
            )//中心の座標
        )

        // 〇　楕円を描画
        drawOval(
            color = Color.Green,
            topLeft = Offset(
                x = canvasQuadrantSize.width*3/4,
                y = canvasQuadrantSize.height*3/4
            ),//楕円の左上の座標
            size = Size(500f, 100f)//楕円のサイズ
        )
    }

}