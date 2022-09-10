package com.evanross.randomapex.model

import androidx.annotation.DrawableRes

data class ApexCharacter(
    @DrawableRes val imageResourceId: Int,
    val name: String,
    val id: Int
)