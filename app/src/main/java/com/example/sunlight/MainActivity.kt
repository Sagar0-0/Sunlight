package com.example.sunlight

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sunlight.data.MainViewModel
import com.example.sunlight.ui.screens.Home
import com.example.sunlight.ui.screens.SkinColor
import com.example.sunlight.ui.screens.SkinExposure
import com.example.sunlight.ui.theme.SunlightTheme
import com.example.sunlight.ui.utils.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SunlightTheme {
                val navController = rememberNavController()
                val mainViewModel: MainViewModel = hiltViewModel()
                NavigationHost(navController, mainViewModel)
            }
        }
    }
}

@Composable
fun NavigationHost(navController: NavHostController, mainViewModel: MainViewModel) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            Home(navController,mainViewModel, Screen.Home.headText)
        }
        composable(Screen.Exposure.route) {
            SkinExposure(navController,mainViewModel, Screen.Exposure.headText)
        }
        composable(Screen.Colour.route) {
            SkinColor(navController,mainViewModel, Screen.Colour.headText)
        }
    }
}

