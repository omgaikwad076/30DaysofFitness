package com.example.a30daysoffitness.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Exercise(
    @StringRes val day : Int,
    @StringRes val name : Int,
    @DrawableRes val image : Int,
    @StringRes val content : Int
)
