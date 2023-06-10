package com.example.exploreng.ui

import com.example.exploreng.data.LocalPlaceProvider
import com.example.exploreng.data.Place

data class ExploreNgUiState(

    val currentPlaces: List<Place> = emptyList(),

    val currentSelectedPlace: Place = LocalPlaceProvider.defaultPlace,      //todo

    val isShowingPlaces: Boolean = true

){
}
