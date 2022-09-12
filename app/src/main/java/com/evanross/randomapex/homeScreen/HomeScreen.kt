package com.evanross.randomapex.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.evanross.randomapex.R
import com.evanross.randomapex.model.ApexCharacter

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltNavGraphViewModel()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            Text(
                text = "Click to roll a random Legend!",
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.onBackground
            )
            Spacer(modifier = Modifier
                .padding(40.dp)
            )
            Button(onClick = {
                viewModel.rollCharacter()
                navController.navigate("apex_character_screen/${viewModel.character.value}")
                },
                modifier = Modifier
                    .align(CenterHorizontally)
            ) {
                Text(
                    text = "Roll",
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun CharacterToggleIcon(
    character: ApexCharacter,
    viewModel: HomeViewModel,
    modifier: Modifier = Modifier
) {
    Box(

    ) {
        Image(
            painter = painterResource(id = character.iconArtImageId),
            contentDescription = character.name
        )
    }
}