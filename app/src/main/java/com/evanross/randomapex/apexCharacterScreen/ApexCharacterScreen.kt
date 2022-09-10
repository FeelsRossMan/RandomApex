package com.evanross.randomapex.apexCharacterScreen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import androidx.navigation.NavController
import com.evanross.randomapex.homeScreen.HomeViewModel
import com.evanross.randomapex.model.ApexCharacter

@Composable
fun ApexCharacterScreen(
    navController: NavController,
    viewModel: ApexCharacterViewModel = hiltNavGraphViewModel(),
    characterId: Int
) {

}