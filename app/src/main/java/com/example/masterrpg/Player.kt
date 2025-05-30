package com.example.masterrpg

import androidx.compose.ui.geometry.Offset

data class Player(
    var position: Offset = Offset(100f, 100f),
    var health: Int = 100,
    var level: Int = 1,
    var experience: Int = 0
) {
    fun moveTo(newPosition: Offset) {
        position = newPosition
    }
}
