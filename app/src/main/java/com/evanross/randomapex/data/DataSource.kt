package com.evanross.randomapex.data

import androidx.compose.ui.graphics.Color
import com.evanross.randomapex.R
import com.evanross.randomapex.model.ApexCharacter
import dagger.Provides


object DataSource {
    val apexCharacters: List<ApexCharacter> = listOf(
        ApexCharacter(
            R.drawable.ash,
            R.drawable.ash_icon,
            "Ash",
            1,
        ),
        ApexCharacter(
            R.drawable.bangalore,
            R.drawable.bangalore_icon,
            "Bangalore",
            2
        ),
        ApexCharacter(
            R.drawable.bloodhound,
            R.drawable.bloodhound_icon,
            "Bloodhound",
            3
        ),
        ApexCharacter(
            R.drawable.caustic,
            R.drawable.caustic_icon,
            "Caustic",
            4
        ),
        ApexCharacter(
            R.drawable.crypto,
            R.drawable.crypto_icon,
            "Crypto",
            5
        ),
        ApexCharacter(
            R.drawable.fuse,
            R.drawable.fuse_icon,
            "Fuse",
            6
        ),
        ApexCharacter(
            R.drawable.gibraltar,
            R.drawable.gibraltar_icon,
            "Gibraltar",
            7
        ),
        ApexCharacter(
            R.drawable.horizon,
            R.drawable.horizon_icon,
            "Horizon",
            8
        ),
        ApexCharacter(
            R.drawable.lifeline,
            R.drawable.lifeline_icon,
            "Lifeline",
            9
        ),
        ApexCharacter(
            R.drawable.loba,
            R.drawable.loba_icon,
            "Loba",
            10
        ),
        ApexCharacter(
            R.drawable.madmaggie,
            R.drawable.mad_maggie_icon,
            "Mad Maggie",
            11
        ),
        ApexCharacter(
            R.drawable.mirage,
            R.drawable.mirage_icon,
            "Mirage",
            12
        ),
        ApexCharacter(
            R.drawable.newcastle,
            R.drawable.newcastle_icon,
            "Newcastle",
            13
        ),
        ApexCharacter(
            R.drawable.octane,
            R.drawable.octane_icon,
            "Octane",
            14
        ),
        ApexCharacter(
            R.drawable.pathfinder,
            R.drawable.pathfinder_icon,
            "Pathfinder",
            15
        ),
        ApexCharacter(
            R.drawable.rampart,
            R.drawable.rampart_icon,
            "Rampart",
            16
        ),
        ApexCharacter(
            R.drawable.revenant,
            R.drawable.revenant_icon,
            "Revenant",
            17
        ),
        ApexCharacter(
            R.drawable.seer,
            R.drawable.seer_icon,
            "Seer",
            18
        ),
        ApexCharacter(
            R.drawable.valkyrie,
            R.drawable.valkyrie_icon,
            "Valkyrie",
            19
        ),
        ApexCharacter(
            R.drawable.vantage,
            R.drawable.vantage_icon,
            "Vantage",
            20
        ),
        ApexCharacter(
            R.drawable.wattson,
            R.drawable.wattson_icon,
            "Wattson",
            21
        ),
        ApexCharacter(
            R.drawable.wraith,
            R.drawable.wraith_icon,
            "Wraith",
            22
        )
    )
}