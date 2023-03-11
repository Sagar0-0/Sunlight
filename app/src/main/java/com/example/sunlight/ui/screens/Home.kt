package com.example.sunlight.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sunlight.data.MainViewModel
import com.example.sunlight.ui.utils.CircularSlider
import com.example.sunlight.ui.utils.Header
import com.example.sunlight.ui.utils.MyBottomSheet

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Home(navController: NavHostController, mainViewModel: MainViewModel, headerText: String) {
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )
    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetShape = RoundedCornerShape(20.dp),
        sheetElevation = 20.dp,
        sheetPeekHeight = 200.dp,
        sheetContent = {
            MyBottomSheet(navController = navController, mainViewModel = mainViewModel)
        }
    ) {
        val duration = rememberSaveable {
            mainViewModel.duration
        }
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item { Header(text = headerText) }

            item {
                Text(
                    modifier = Modifier.padding(16.dp),
                    text = "Total Duration",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            item {
                Box(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .height(232.dp)
                        .width(379.dp)
                        .background(Color.Black.copy(0.1f)),
                    contentAlignment = Alignment.Center
                ) {
                    CircularSlider(
                        modifier = Modifier.size(200.dp),
                        stroke = 25f
                    ) {
                        mainViewModel.onDurationChange(it)
                    }

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "Duration", fontSize = 20.sp)
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(text = "${duration.value} hr", fontSize = 26.sp)
                    }
                }

            }
        }
    }
}