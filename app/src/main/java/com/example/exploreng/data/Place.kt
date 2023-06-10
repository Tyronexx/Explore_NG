package com.example.exploreng.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Place(

    @StringRes val placeName: Int,
    @DrawableRes val placeImage: Int,
    @StringRes val placeDetails: Int,
    /**What state is Place in*/
    val state: State,

)
