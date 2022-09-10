package com.evanross.randomapex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.evanross.randomapex.apexCharacterScreen.ApexCharacterScreen
import com.evanross.randomapex.homeScreen.HomeScreen
import com.evanross.randomapex.ui.theme.RandomApexComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RandomApexComposeTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "home_screen"
                ) {
                    composable("home_screen") {
                        // Add the Composable function here for the home screen
                        HomeScreen(navController = navController)
                    }

                    composable("apex_character_screen/{apexLegendId}",
                        arguments = listOf(
                            navArgument("apexLegendId") {
                                type = NavType.IntType
                            }
                        )
                    ) {
                        val apexLegendId = remember {
                            it.arguments?.getInt("apexLegendId")
                        }
                        // Add the Composable function here for the rolled character screen
                        ApexCharacterScreen(
                            navController = navController,
                            characterId = apexLegendId ?: 0
                        )

                    }
                }
            }
        }
    }
}

