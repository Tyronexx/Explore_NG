package com.example.exploreng.ui

import androidx.lifecycle.ViewModel
import com.example.exploreng.data.Place
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ExploreNgViewModel:ViewModel() {

    private val _uiState = MutableStateFlow(ExploreNgUiState())
    val uiState: StateFlow<ExploreNgUiState> = _uiState.asStateFlow()

    /**Generates list of places*/
    fun updateCurrentPlaces(state : List<Place>){
        _uiState.update {
            it.copy(
                currentPlaces = state
            )
        }
    }

    /**Generates data for place details (when place item is clicked)*/
    fun updateCurrentPlace(place: Place){
        _uiState.update {
            it.copy(
                currentSelectedPlace = place,
                isShowingPlaces = false
            )
        }
    }
}