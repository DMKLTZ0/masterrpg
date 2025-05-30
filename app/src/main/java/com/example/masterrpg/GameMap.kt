package com.example.masterrpg

import androidx.compose.ui.geometry.Offset

class GameMap {
    private val tileSize = 32f

    // Prosta mapa - true = można przejść, false = przeszkoda
    private val walkableMap = Array(20) { Array(30) { true } }

    init {
        // Dodaj kilka przeszkód
        walkableMap[5][5] = false
        walkableMap[5][6] = false
        walkableMap[6][5] = false
        walkableMap[6][6] = false
    }

    fun isWalkable(position: Offset): Boolean {
        val tileX = (position.x / tileSize).toInt()
        val tileY = (position.y / tileSize).toInt()

        if (tileX < 0 || tileX >= walkableMap[0].size ||
            tileY < 0 || tileY >= walkableMap.size) {
            return false
        }

        return walkableMap[tileY][tileX]
    }
}
