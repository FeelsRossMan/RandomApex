package com.evanross.randomapex.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

object AllowedCharactersList {
    val allowedCharacterList: List<MutableState<Boolean>> = List(DataSource.apexCharacters.size) {
        mutableStateOf(true)
    }
}