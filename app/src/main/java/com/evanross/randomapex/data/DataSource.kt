package com.evanross.randomapex.data

import androidx.compose.ui.graphics.Color
import com.evanross.randomapex.R
import com.evanross.randomapex.model.ApexCharacter
import dagger.Provides


object DataSource {
    val apexCharacters: List<ApexCharacter> = listOf(
        ApexCharacter(
            R.drawable.ash,
            "Ash",
            1,
        ),
        ApexCharacter(
            R.drawable.bangalore,
            "Bangalore",
            2
        ),
        ApexCharacter(
            R.drawable.bloodhound,
            "Bloodhound",
            3
        ),
        ApexCharacter(
            R.drawable.caustic,
            "Caustic",
            4
        ),
        ApexCharacter(
            R.drawable.crypto,
            "Crypto",
            5
        ),
        ApexCharacter(
            R.drawable.fuse,
            "Fuse",
            6
        ),
        ApexCharacter(
            R.drawable.gibraltar,
            "Gibraltar",
            7
        ),
        ApexCharacter(
            R.drawable.horizon,
            "Horizon",
            8
        ),
        ApexCharacter(
            R.drawable.lifeline,
            "Lifeline",
            9
        ),
        ApexCharacter(
            R.drawable.loba,
            "Loba",
            10
        ),
        ApexCharacter(
            R.drawable.madmaggie,
            "Mad Maggie",
            11
        ),
        ApexCharacter(
            R.drawable.mirage,
            "Mirage",
            12
        ),
        ApexCharacter(
            R.drawable.newcastle,
            "Newcastle",
            13
        ),
        ApexCharacter(
            R.drawable.octane,
            "Octane",
            14
        ),
        ApexCharacter(
            R.drawable.pathfinder,
            "Pathfinder",
            15
        ),
        ApexCharacter(
            R.drawable.rampart,
            "Rampart",
            16
        ),
        ApexCharacter(
            R.drawable.revenant,
            "Revenant",
            17
        ),
        ApexCharacter(
            R.drawable.seer,
            "Seer",
            18
        ),
        ApexCharacter(
            R.drawable.valkyrie,
            "Valkyrie",
            19
        ),
        ApexCharacter(
            R.drawable.vantage,
            "Vantage",
            20
        ),
        ApexCharacter(
            R.drawable.wattson,
            "Wattson",
            21
        ),
        ApexCharacter(
            R.drawable.wraith,
            "Wraith",
            22
        )
    )
}