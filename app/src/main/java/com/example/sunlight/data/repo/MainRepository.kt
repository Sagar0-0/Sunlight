package com.example.sunlight.data.repo

import com.example.sunlight.data.entity.ColorItem
import com.example.sunlight.data.entity.ExposureItem

/*
Using interface we can define a contract for fake testing repo
 */
interface MainRepository {
    fun getSkinList() : List<ExposureItem>
    fun getColorList() : List<ColorItem>
}