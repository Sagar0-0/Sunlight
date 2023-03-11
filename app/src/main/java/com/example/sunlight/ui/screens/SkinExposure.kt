package com.example.sunlight.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sunlight.R
import com.example.sunlight.data.MainViewModel
import com.example.sunlight.ui.utils.Header
import com.example.sunlight.ui.utils.Screen

@Composable
fun SkinExposure(
    navController: NavHostController,
    mainViewModel: MainViewModel,
    headerText: String
) {
    val selectedItemIndex = remember {
        mainViewModel.selectedSkin
    }.value.index
    Column(modifier = Modifier.fillMaxSize()) {
        Header(text = headerText)
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )
        val list = mainViewModel.getSkinList()
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(list) { item ->
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(
                            if (item.index == selectedItemIndex) Color.Black.copy(
                                0.2f
                            ) else Color.Red.copy(0.2f)
                        )
                        .clickable {
                            mainViewModel.onExposureChange(index = item.index, text = item.text)
                            navController.navigate(Screen.Home.route){
                                popUpTo(0)
                            }
                        },
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        modifier = Modifier.size(100.dp),
                        painter = painterResource(id = R.drawable.boy_avatar),
                        contentDescription = ""
                    )
                    Text(text = item.text, fontSize = 26.sp)
                }
            }
        }
    }
}