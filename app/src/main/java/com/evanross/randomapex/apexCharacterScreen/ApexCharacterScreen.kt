package com.evanross.randomapex.apexCharacterScreen

import android.provider.ContactsContract
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.TopStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import androidx.navigation.NavController
import com.evanross.randomapex.R
import com.evanross.randomapex.data.DataSource
import com.evanross.randomapex.homeScreen.HomeViewModel
import com.evanross.randomapex.model.ApexCharacter

@Composable
fun ApexCharacterScreen(
    navController: NavController,
    viewModel: ApexCharacterViewModel = hiltNavGraphViewModel(),
    characterId: Int
) {
    val apexCharacter = remember {
        DataSource.apexCharacters[characterId]
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                //TODO: Setup the gradient from the legends color scheme
                MaterialTheme.colors.background
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
            Image(
                painter = painterResource(id = apexCharacter.imageResourceId),
                contentDescription = apexCharacter.name,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .align(CenterHorizontally)
            )
            Spacer(modifier = Modifier
                .padding(vertical = 20.dp)
            )
            Text(
                text = apexCharacter.name,
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier
                    .align(CenterHorizontally)
            )
            Spacer(
                modifier = Modifier
                    .padding(vertical = 20.dp)
            )
        }
    }

}