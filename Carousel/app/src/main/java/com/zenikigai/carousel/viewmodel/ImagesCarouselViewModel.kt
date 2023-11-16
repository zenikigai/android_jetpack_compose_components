package com.zenikigai.carousel.viewmodel

import androidx.lifecycle.ViewModel
import com.zenikigai.carousel.R

class ImagesCarouselViewModel : ViewModel() {
    val previewImages = listOf(
        R.drawable.cuisine1,
        R.drawable.cuisine2,
        R.drawable.cuisine3,
        R.drawable.cuisine4,
        R.drawable.cuisine5
    )
}