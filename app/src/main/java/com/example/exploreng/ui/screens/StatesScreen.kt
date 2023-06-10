package com.example.exploreng.ui

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.exploreng.data.LocalPlaceProvider
import com.example.exploreng.data.Screen
import com.example.exploreng.data.State
import com.example.exploreng.data.StateDetails
import com.example.exploreng.ui.theme.ExploreNGTheme

private const val TAG = "StatesScreen"


@Composable
fun StatesScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
//    onStateClicked: (StateDetails) -> Unit,
//    states: List<State>
){
/**  track selected state*/
//    var selectedState:StateDetails? by rememberSaveable { mutableStateOf(null ) }

    val stateList = LocalPlaceProvider.stateList

    LazyColumn(
        modifier = modifier
    ){
        items(
            items = stateList,
//            key = { state -> state.stateName}
        ){state ->
            StateItem(
                stateDetails = state,
                modifier = modifier.padding(5.dp),
                navController = navController
//                onStateCardClicked = { onStateClicked(state) }
            )
        }
    }


//    states.forEach { state ->
//        StateItem(
//            modifier = modifier.padding(5.dp),
//            state = state,
//            onStateCardClicked = {
//                selectedState = state
//                onStateClicked(state)
//            }
//        )
//    }
//
}


@Composable
private fun StateItem(
    stateDetails: StateDetails,
    modifier: Modifier = Modifier.fillMaxWidth(),
    navController: NavController
//    onStateCardClicked: () -> Unit                 //todo(check)
){
    Card(
//        onClick = onStateCardClicked,
        modifier = modifier
            .wrapContentSize()
            .clickable {
                when(stateDetails.state){
                    State.Abuja ->{
                        navController.navigate(Screen.PlacesScreen.withArgs("Abuja"))
                    }
                    State.Lagos ->{
                        navController.navigate(Screen.PlacesScreen.withArgs("Lagos"))
                    }
                    State.Kaduna ->{
                        navController.navigate(Screen.PlacesScreen.withArgs("Kaduna"))
                    }
                }
            }
    ) {
        Row(
            modifier = modifier
                .padding(5.dp)
                .fillMaxWidth()
            ,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            StateItemImage(
                stateDetails = stateDetails,
                modifier = Modifier.padding(5.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = stringResource(stateDetails.stateName),
                Modifier.weight(1f)
            )
        }
    }

}


@Composable
private fun StateItemImage(
    modifier: Modifier = Modifier,
    stateDetails: StateDetails
){
    Box(
        modifier = modifier
            .size(98.dp)
            .padding(5.dp)
            .clip(RoundedCornerShape(15.dp))
    ) {
        Image(
            painter = painterResource(stateDetails.StateImage),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
    }
}

















@Preview(showSystemUi = true)
@Composable
private fun Review(){
    ExploreNGTheme {
//        StateItem(state = State.Kaduna, onStateCardClicked = { }, modifier = Modifier.padding(5.dp))
//        StatesScreen(onStateClicked = { },)
    }
}