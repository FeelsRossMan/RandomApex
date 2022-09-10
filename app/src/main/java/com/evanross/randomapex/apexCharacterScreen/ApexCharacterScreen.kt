package com.evanross.randomapex.apexCharacterScreen

import android.provider.ContactsContract
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
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
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(
                //TODO: Setup the gradient from the legends color scheme
                MaterialTheme.colors.background
            )
    ) {
        Column {
            Image(
                painter = painterResource(id = apexCharacter.imageResourceId),
                contentDescription = apexCharacter.name,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
            )
            Spacer(modifier = Modifier
                .padding(vertical = 20.dp)
            )
            Text(text = apexCharacter.name)
        }
    }

}