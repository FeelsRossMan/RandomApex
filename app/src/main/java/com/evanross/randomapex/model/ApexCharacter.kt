package com.evanross.randomapex.model

import androidx.annotation.DrawableRes

data class ApexCharacter(
    @DrawableRes val splashArtImageId: Int,
    @DrawableRes val iconArtImageId: Int,
    val name: String,
    val id: Int
)