package com.evanross.randomapex.homeScreen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
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
            // Character Toggle section
            CharacterToggleList(
                viewModel = viewModel,
                characters = viewModel.characters
            )

            Spacer(modifier = Modifier
                .padding(40.dp)
            )
            RollButton(
                viewModel = viewModel,
                navController = navController
            )
        }
    }
}

@Composable
fun CharacterToggleIcon(
    character: ApexCharacter,
    viewModel: HomeViewModel,
    modifier: Modifier = Modifier,
    selected: Boolean
) {
    Box(
        modifier = Modifier
            .padding(1.dp)
    ) {
        Image(
            painter = painterResource(id = character.iconArtImageId),
            contentDescription = character.name,
            colorFilter = ColorFilter.tint(
                if (selected) {
                    if (isSystemInDarkTheme()) {
                        Color.LightGray
                    } else {
                        Color.DarkGray
                    }
                } else Color.Gray
            ),
            modifier = modifier
                .clickable {
                    viewModel.selectCharacter(character.id)
                }
                .then(
                    if (selected) {
                        Modifier
                            .border(
                                width = 1.dp,
                                color = if (isSystemInDarkTheme()) {
                                    Color.White
                                } else {
                                    Color.Black
                                },
                                shape = RoundedCornerShape(3.dp),
                            )
                    } else Modifier
                )
                .size(50.dp)
                .clip(shape = RoundedCornerShape(0.dp))
        )
    }
}


@Composable
fun CharacterToggleRow(
    viewModel: HomeViewModel,
    characters: List<ApexCharacter>,
    charactersInRow: Int,
    row: Int
) {
    val lastRow: Boolean = (row+1)*charactersInRow >= characters.size
    val lastCharacter = if (lastRow) characters.size else (row+1)*charactersInRow
    Column {
        Row {
            characters.subList(charactersInRow*row, lastCharacter).forEach {
                CharacterToggleIcon(
                    character = it,
                    viewModel = viewModel,
                    selected = viewModel.isCharacterSelected(it.id) ?: false
                )
            }
        }
    }
}

@Composable
fun CharacterToggleList(
    viewModel: HomeViewModel,
    characters: List<ApexCharacter>
) {
    val charactersInRow = 6
    val additionalRow = if(characters.size % charactersInRow > 0) 1 else 0
    val rows = characters.size/charactersInRow + additionalRow
    Column {
        for (i in 0 until rows) {
          CharacterToggleRow(
              viewModel = viewModel,
              characters = characters,
              charactersInRow = charactersInRow,
              row = i)  
        }
    }
}

@Composable
fun RollButton(
    viewModel: HomeViewModel,
    navController: NavController
) {
    Button(onClick = {
        val valid = viewModel.rollCharacter()
        if (valid) {
            navController.navigate("apex_character_screen/${viewModel.returnId}")
        }
    }
    ) {
        Text(
            text = "Roll",
            textAlign = TextAlign.Center
        )
    }
}