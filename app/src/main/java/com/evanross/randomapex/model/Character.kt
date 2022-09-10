package com.evanross.randomapex.model

import androidx.annotation.DrawableRes

data class Character(
    @DrawableRes val imageResourceId: Int,
    val name: String
)