package com.example.sunlight.ui.utils

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyCard(textPrimary:String, textSecondary: String,icon: ImageVector, onClick: () -> Unit = {}) {
    Card(
        modifier = Modifier
            .width(185.dp)
            .height(92.dp)
            .clickable {
                onClick()
            },
        backgroundColor = Color.Black.copy(0.4f),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .padding(16.dp)
        ) {
            Icon(
                modifier = Modifier
                    .size(24.dp),
                imageVector = icon,
                contentDescription = "",
                tint = Color.White
            )
            Column(modifier = Modifier.padding(start = 8.dp)) {
                Text(
                    text = textPrimary,
                    fontSize = 18.sp,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = textSecondary,
                    fontSize = 18.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }

    }
}

@Composable
@Preview
fun MyCardPreview() {
    MyCard(textPrimary = "Skin Exposure", textSecondary = "40%", icon = Icons.Filled.Search)
}