package com.example.sunlight.ui.utils

sealed class Screen(val route: String, val headText: String) {
    object Home : Screen("Home", "Bengaluru, Karnataka")
    object Exposure : Screen("Exposure","Skin Exposure")
    object Colour : Screen("Colour","Skin Color")
}