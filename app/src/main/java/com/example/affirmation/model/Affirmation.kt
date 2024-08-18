package com.example.affirmation.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirmation(
    @StringRes val title: Int,
    @DrawableRes val image: Int
)
