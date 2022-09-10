package com.evanross.randomapex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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


                    }
                }
            }
        }
    }
}

