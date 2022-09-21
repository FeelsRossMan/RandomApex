package com.evanross.randomapex.util

import androidx.compose.ui.graphics.Color
import com.evanross.randomapex.ui.theme.*
import timber.log.Timber

fun nameToColor(name: String?) : Color {
    return when(name) {
        "Ash" -> Ash
        "Bangalore" -> Bangalore
        "Bloodhound" -> Bloodhound
        "Caustic" -> Caustic
        "Crypto" -> Crypto
        "Fuse" -> Fuse
        "Gibraltar" -> Gibraltar
        "Horizon" -> Horizon
        "Lifeline" -> Lifeline
        "Loba" -> Loba
        "Mad Maggie" -> MadMaggie
        "Mirage" -> Mirage
        "Newcastle" -> Newcastle
        "Octane" -> Octane
        "Pathfinder" -> Pathfinder
        "Rampart" -> Rampart
        "Revenant" -> Revenant
        "Seer" -> Seer
        "Valkyrie" -> Valkyrie
        "Vantage" -> Vantage
        "Wraith" -> Wraith
        "Wattson" -> Wattson
        else -> {
            Timber.d( "Color not found for ${name?:"unknown"}")
            Color.Black

        }
    }
}