package com.example.masterrpg

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset

class GameState {
    var player by mutableStateOf(Player())

    fun movePlayerTo(newPosition: Offset) {
        player.moveTo(newPosition)
    }
}
