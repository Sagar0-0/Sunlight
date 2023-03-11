package com.example.sunlight.ui.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.sunlight.data.MainViewModel

@Composable
fun MyBottomSheet(navController: NavHostController,mainViewModel: MainViewModel) {
    LazyColumn(
        modifier = Modifier
            .heightIn(min = 200.dp, max = 300.dp)
            .fillMaxSize()
            .background(Color.Black.copy(0.1f))
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Spacer(
                modifier = Modifier
                    .height(3.dp)
                    .width(70.dp)
                    .background(Color.White)
            )
        }
        item {
            Spacer(
                modifier = Modifier
                    .height(20.dp)
            )
        }
        item {
            Row {
                MyCard(
                    textPrimary = "Sunscreen",
                    textSecondary = "40 SPF",
                    icon = Icons.Default.Search
                )
                Spacer(
                    modifier = Modifier
                        .width(5.dp)
                )
                MyCard(
                    textPrimary = "Skin Exposure",
                    textSecondary = mainViewModel.selectedSkin.value.text,
                    icon = Icons.Default.Settings
                ) {
                    navController.navigate(Screen.Exposure.route)
                }
            }
        }

        item {
            Spacer(
                modifier = Modifier
                    .height(10.dp)
            )
        }

        item {
            Row {
                MyCard(
                    textPrimary = "Skin Color",
                    textSecondary = mainViewModel.selectedColor.value.text,
                    icon = Icons.Default.Person
                ) {
                    navController.navigate(Screen.Colour.route)
                }
                Spacer(
                    modifier = Modifier
                        .width(5.dp)
                )
                MyCard(
                    textPrimary = "Music",
                    textSecondary = "Spotify",
                    icon = Icons.Default.Menu
                )
            }
        }

        item {
            Row(Modifier.fillMaxWidth()) {
                Button(
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green),
                    onClick = { /*TODO*/ }) {
                    Text(
                        text = "Schedule",
                        modifier = Modifier
                            .width(155.dp)
                            .align(Alignment.CenterVertically)
                    )
                }
                Spacer(
                    modifier = Modifier
                        .width(5.dp)
                )
                Button(
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
                    onClick = { /*TODO*/ }) {
                    Text(
                        text = "Start",
                        modifier = Modifier
                            .width(155.dp)
                            .align(Alignment.CenterVertically)
                    )
                }
            }
        }
    }
}
