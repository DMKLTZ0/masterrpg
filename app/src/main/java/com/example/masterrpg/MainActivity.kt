package com.example.masterrpg

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import com.example.masterrpg.ui.theme.MasterRPGTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MasterRPGTheme {
                GameScreen()
            }
        }
    }
}

@Composable
fun GameScreen() {
    var playerPosition by remember { mutableStateOf(Offset(100f, 100f)) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectTapGestures { tapOffset ->
                        playerPosition = tapOffset
                    }
                }
        ) {
            drawGameMap()
            drawPlayer(playerPosition)
        }
    }
}

fun DrawScope.drawGameMap() {
    val tileSize = 32f
    val mapWidth = (size.width / tileSize).toInt()
    val mapHeight = (size.height / tileSize).toInt()

    for (x in 0..mapWidth) {
        for (y in 0..mapHeight) {
            val color = if ((x + y) % 2 == 0) Color.Green else Color(0xFF006400) // DarkGreen
            drawRect(
                color = color,
                topLeft = Offset(x * tileSize, y * tileSize),
                size = Size(tileSize, tileSize)
            )
        }
    }
}

fun DrawScope.drawPlayer(playerPosition: Offset) {
    drawCircle(
        color = Color.Blue,
        radius = 20f,
        center = playerPosition
    )
}

@Preview(showBackground = true)
@Composable
fun GameScreenPreview() {
    MasterRPGTheme {
        GameScreen()
    }
}
