package com.zenikigai.carousel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.zenikigai.carousel.ui.ImageCarousel
import com.zenikigai.carousel.ui.theme.LearnTheme
import com.zenikigai.carousel.viewmodel.ImagesCarouselViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel = ViewModelProvider(this).get(ImagesCarouselViewModel::class.java)
                    ImageCarousel(images = viewModel.previewImages)

                }
            }
        }
    }
}




























