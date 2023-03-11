package com.example.sunlight.data.repo

import androidx.compose.ui.graphics.Color
import com.example.sunlight.R
import com.example.sunlight.data.entity.ColorItem
import com.example.sunlight.data.entity.ExposureItem

/*
Repo will get data from our backend server but here we are just providing by our own
 */
class MainRepoImpl: MainRepository {

    override fun getSkinList() : List<ExposureItem> {
        return listOf(
            ExposureItem(0,"40%", R.drawable.boy_avatar),
            ExposureItem(1,"30%", R.drawable.boy_avatar),
            ExposureItem(2,"45%", R.drawable.boy_avatar),
            ExposureItem(3,"50%", R.drawable.boy_avatar),
            ExposureItem(4,"25%", R.drawable.boy_avatar),
            ExposureItem(5,"40%", R.drawable.boy_avatar),
            ExposureItem(6,"20%", R.drawable.boy_avatar),
            ExposureItem(7,"20%", R.drawable.boy_avatar),
        )
    }

    override fun getColorList(): List<ColorItem> {
        return listOf(
            ColorItem(0,"Fair", Color(0xFFC8AC99)),
            ColorItem(0,"Light", Color(0xFFB1886C)),
            ColorItem(0,"Medium Light", Color(0xFFA0795F)),
            ColorItem(0,"Medium", Color(0xFF8C624E)),
            ColorItem(0,"Medium Dark", Color(0xFF634B3F)),
            ColorItem(0,"Dark", Color(0xFF544239))
        )
    }


}