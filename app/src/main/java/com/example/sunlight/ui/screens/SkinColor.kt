package com.example.sunlight.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sunlight.data.MainViewModel
import com.example.sunlight.ui.utils.Header
import com.example.sunlight.ui.utils.Screen

@Composable
fun SkinColor(
    navController: NavHostController,
    mainViewModel: MainViewModel,
    headerText: String
) {
    val selectedItemIndex = remember {
        mainViewModel.selectedColor
    }.value.index
    Column(modifier = Modifier.fillMaxSize()) {
        Header(text = headerText)
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )
        Text(
            modifier = Modifier.padding(16.dp),
            text = "Total Duration",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        val list = mainViewModel.getColorList()
        LazyColumn {
            items(list) { item ->
                Row(
                    modifier = Modifier
                        .padding(10.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .fillMaxWidth()
                        .background(item.color)
                        .clickable {
                            mainViewModel.onColorChange(item.index,item.text,item.color)
                            navController.navigate(Screen.Home.route) {
                                popUpTo(0)
                            }
                        }
                        .padding(15.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = item.text, fontSize = 20.sp, color = Color.White)

//                    if(item.index==selectedItemIndex){
//                        Icon(modifier=Modifier.align(Alignment.CenterVertically),imageVector = Icons.Default.Check, contentDescription = "", tint = Color.Green)
//                    }Have to fix
                }
            }
        }
    }
}