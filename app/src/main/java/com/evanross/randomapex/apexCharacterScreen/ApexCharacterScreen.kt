package com.evanross.randomapex.apexCharacterScreen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.TopStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import androidx.navigation.NavController
import com.evanross.randomapex.util.nameToColor


@ExperimentalAnimationApi
@Composable
fun ApexCharacterScreen(
    navController: NavController,
    viewModel: ApexCharacterViewModel = hiltNavGraphViewModel()
) {
    val apexCharacter = remember {
        viewModel.setRandomApexCharacter()
        viewModel.apexCharacter
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                //Done: Setup the gradient from the legends color scheme
                Brush.verticalGradient(
                    listOf(
                        MaterialTheme.colors.background,
                        nameToColor(apexCharacter.value.name)
                    )
                )
            )
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            tint = MaterialTheme.colors.onBackground,
            modifier = Modifier
                .size(36.dp)
                .offset(16.dp, 16.dp)
                .clickable {
                    navController.popBackStack()
                }
                .align(TopStart)
        )

        Column (
            modifier = Modifier
                .align(Center)
        ){
            AnimatedVisibility(
                visible = viewModel.animationComplete,
                enter = slideInVertically(
                    initialOffsetY = {-400}
                )
            ) {
                RolledLoadoutSection(viewModel = viewModel)
            }
            viewModel.animationComplete = true
            Spacer(
                modifier = Modifier
                    .padding(vertical = 20.dp)
            )
            Button(
                onClick = {
                    viewModel.setRandomApexCharacter()

                },
                modifier = Modifier
                    .align(CenterHorizontally)
                ) {
                Text(
                    text = "Re-roll",
                    color = MaterialTheme.colors.onBackground,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun RolledLoadoutSection(
    modifier: Modifier = Modifier,
    viewModel: ApexCharacterViewModel
) {
    val apexCharacter = remember {
        viewModel.apexCharacter
    }
    Column {
        Crossfade(targetState = apexCharacter.value, animationSpec = tween(350)) {


            Image(
                painter = painterResource(id = it.splashArtImageId),
                contentDescription = it.name,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .align(CenterHorizontally)
            )
        }
        Spacer(modifier = Modifier
            .padding(vertical = 20.dp)
        )
        Text(
            text = apexCharacter.value.name,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier
                .align(CenterHorizontally)
        )
    }
    
}