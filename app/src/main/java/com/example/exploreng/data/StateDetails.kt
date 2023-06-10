package com.example.exploreng.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class StateDetails (
    @StringRes val stateName: Int,
    @DrawableRes val StateImage: Int,
    val state: State
)


//{
//    Abuja(title = R.string.Abuja, image = R.drawable.abuja_homepage),
//    Lagos(title = R.string.Lagos, image = R.drawable.lagos_homepage),
//    Kaduna(title = R.string.kaduna, image = R.drawable.kaduna_homepage),
//}