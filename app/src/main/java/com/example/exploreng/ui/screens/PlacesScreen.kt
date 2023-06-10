package com.example.exploreng.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.exploreng.data.LocalPlaceProvider
import com.example.exploreng.data.Place
import com.example.exploreng.data.Screen
import com.example.exploreng.data.State
import com.example.exploreng.ui.theme.ExploreNGTheme

//second screen

private const val TAG = "PlacesScreen"

@Composable
fun PlacesScreen(
//    exploreNgUiState: ExploreNgUiState,
    modifier: Modifier = Modifier,
    navController: NavController,
    stateString: String?,
){
//    val currentPlaces = exploreNgUiState.currentPlaces

    Log.d(TAG, "$stateString in places screen")
    val state: State = when(stateString){
        "Abuja" -> State.Abuja
        "Kaduna" -> State.Kaduna
        "Lagos" -> State.Lagos
        else -> State.Abuja
    }

    LazyColumn(
        modifier = modifier,
    ){
        val temp = LocalPlaceProvider.allPlaces.let { it ->
            it.filter { item ->
                item.state == state
            }
        }
        items(
            items = temp,
//            key = { currentPlace -> currentPlace.placeName }
        ){
            PlaceItem(
                place = it,
//                onPlaceCardClicked = {
//                    onPlaceClicked(currentPlace)    //todo(check)
//                },
                modifier = modifier.padding(10.dp),
                navController = navController
            )
        }

    }

}

@Composable
private fun PlaceItem(
    modifier: Modifier = Modifier.fillMaxWidth(),
    place: Place,
    navController: NavController
//    onPlaceCardClicked: () -> Unit
){
    Card(
//        onClick = onPlaceCardClicked,
        modifier = modifier
            .wrapContentSize()
            .clickable {
                navController.navigate(Screen.DetailsScreen.withArgs("${place.placeDetails}/${place.placeImage}/${place.placeName}"))          //arguments to carry on to third screenz
            }
    ) {
        Row(
            modifier = modifier
                .padding(5.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            PlaceItemImage(
                place = place,
                modifier = Modifier.weight(1.1f)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = stringResource(id = place.placeName),
                Modifier.weight(1.5f),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
        }
    }


}

@Composable
private fun PlaceItemImage(
    modifier: Modifier = Modifier,
    place: Place
){
    Box(
        modifier = modifier
            .size(68.dp)
            .padding(3.dp)
            .clip(RoundedCornerShape(10.dp)),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(id = place.placeImage),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
    }
}


















@Preview(showSystemUi = true)
@Composable
fun Reviews(){
    ExploreNGTheme {
//        PlaceItem(place = LocalPlaceProvider.allPlaces[2], onPlaceCardClicked = {})
//
//        PlacesScreen(
//            exploreNgUiState = ExploreNgUiState(),
//            onPlaceClicked = {},
//            modifier = Modifier,
//            currentPlaces = abuja
//        )
//
    }
}