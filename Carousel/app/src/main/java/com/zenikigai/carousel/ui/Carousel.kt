package com.zenikigai.carousel.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.zenikigai.carousel.R
import kotlinx.coroutines.delay
import kotlin.math.roundToInt

@Composable
fun ImageCarousel(
    images: List<Int>,
) {
    var currentIndex by remember { mutableStateOf(0) }
    val offsetX = remember { mutableStateOf(0f) }

    LaunchedEffect(true) {
        while (true) {
            delay(1500)
            currentIndex = (currentIndex + 1) % images.size
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {

        Image(
            contentScale = ContentScale.Crop,
            painter = painterResource(id = images[currentIndex]),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)  // Adjust the height as needed
                .padding(0.dp)
                .animateContentSize()
                .offset { IntOffset(offsetX.value.roundToInt(), 0) }
        )
    }

}

@Composable
private fun AnimateOffsetTransition(offset: MutableState<Float>, targetValue: Float) {
    animateFloatAsState(
        targetValue = targetValue,
        animationSpec = tween(durationMillis = 500), label = ""
    ).value.let {
        offset.value = it
    }
}

@Preview
@Composable
fun AutomaticImageCarouselPreview() {
    val previewImages = listOf(
        R.drawable.cuisine1,
        R.drawable.cuisine2,
        R.drawable.cuisine3,
        R.drawable.cuisine4,
        R.drawable.cuisine5
    )
    ImageCarousel(images = previewImages)
}