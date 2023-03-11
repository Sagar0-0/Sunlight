package com.example.sunlight.data

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.sunlight.R
import com.example.sunlight.data.entity.ColorItem
import com.example.sunlight.data.entity.ExposureItem
import com.example.sunlight.data.repo.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {
    val duration = mutableStateOf(0.0f)

    //We have to store these things in preference or room
    val selectedSkin = mutableStateOf(ExposureItem(0,"40%", R.drawable.boy_avatar))
    val selectedColor = mutableStateOf(ColorItem(1,"Light", Color(0xFFC8AC99)))

    fun onDurationChange(newDuration: Float){
        duration.value=newDuration
    }

    fun getSkinList() : List<ExposureItem> {
        return mainRepository.getSkinList()
    }
    fun onExposureChange(index:Int, text:String){
        selectedSkin.value = ExposureItem(index,text,R.drawable.boy_avatar)
    }

    fun getColorList() : List<ColorItem>{
        return mainRepository.getColorList()
    }
    fun onColorChange(index:Int,text:String,color:Color){
        selectedColor.value = ColorItem(index,text,color)
    }
}