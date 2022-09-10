package com.evanross.randomapex.homeScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import androidx.navigation.NavController

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltNavGraphViewModel()
) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
        ) {
            Text(
                text = "Click to roll a random Legend!"
            )
            Spacer(modifier = Modifier
                .padding(40.dp)
            )
            Button(onClick = {
                viewModel.rollCharacter()
                navController.navigate("apex_character_screen/${viewModel.character.value}")
            }) {
                Text(
                    text = "Roll"
                )
            }
        }
    }
}