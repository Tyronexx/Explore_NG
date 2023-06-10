package com.example.exploreng.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exploreng.R
import com.example.exploreng.data.LocalPlaceProvider
import com.example.exploreng.ui.theme.ExploreNGTheme


//todo(add place name with top app bar)
//todo(send "currentSelectedPlace" from PlacesScreen)
//todo(when "PlaceDetailsScreen" is called pass "ExploreNgUiState.currentSelectedPlace" to "place")

private const val TAG = "PlaceDetailsScreen"


@Composable
fun PlaceDetailsScreen(
    modifier: Modifier = Modifier,
    detailsRes: String?,
    imageRes: String?,
    nameRes: String?,
//    state: String?
){
    Log.d(TAG, "details screen got a $detailsRes as detailsRes, $nameRes as name and $imageRes as imageRes")
    val details = detailsRes?.toInt()
    val img = imageRes?.toInt()
    val placeName = nameRes?.toInt()
//    val stateName = state?.toInt()



    Column(
        modifier = modifier.padding(5.dp),
    ) {
        Text(
            text = stringResource(id = placeName!!),
            fontSize = 40.sp,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            modifier = modifier
                .padding(5.dp)
                .fillMaxWidth()
        )
        DetailsPageImage(
            imageRes = img!!,
            modifier = modifier
                .padding(10.dp)
                .weight(1f)
        )
        Text(
            text = stringResource(id = details!!),
            Modifier
                .padding(10.dp)
                .weight(1f),
            fontFamily = FontFamily.Serif
        )
        /*
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(10.dp)
                .weight(1f),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Location: ")

            Text(
                text = stringResource(id = placeName!!),
            )

        }
//        Spacer(modifier = Modifier.weight(1f))
        */
    }
}

@Composable
private fun DetailsPageImage(
    modifier : Modifier = Modifier,
    imageRes: Int,
){
    Box(
        modifier = modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(10.dp)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxWidth()
        )
    }
}














@Preview(showSystemUi = true)
@Composable
private fun DetailsPreview(){
    ExploreNGTheme {
        PlaceDetailsScreen(
            detailsRes = (R.string.dunes_details).toString(),
            imageRes = (R.drawable.dunes_center).toString(),
            nameRes = (R.string.dunes).toString()
        )
    }
}