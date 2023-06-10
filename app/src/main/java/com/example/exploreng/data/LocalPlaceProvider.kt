package com.example.exploreng.data

import com.example.exploreng.R

object LocalPlaceProvider {

    val allPlaces = listOf(
//  ABUJA
        Place(
            placeName = R.string.jabi_lake_mall,
            placeImage = R.drawable.jabi_lake_mall,
            placeDetails = R.string.jabi_lake_mall_details,
            state = State.Abuja
        ),
        Place(
            R.string.an_Noor_Mosque,
            R.drawable.an_noor_mosque,
            R.string.an_noor_mosque_details,
            State.Abuja
        ),
        Place(
            R.string.dunes,
            R.drawable.dunes_center,
            R.string.dunes_details,
            State.Abuja
        ),
        Place(
            R.string.usuma_dam,
            R.drawable.usman_dam,
            R.string.usuma_dam_details,
            State.Abuja
        ),
        Place(
            R.string.thought_pyramid_art_centre,
            R.drawable.thought_pyramid_art_centre,
            R.string.thought_pyramid_art_centre_details,
            State.Abuja
        ),
        Place(
            R.string.jabi_boat_club,
            R.drawable.jabi_boat_club,
            R.string.jabi_boat_club_datails,
            State.Abuja
        ),
//  LAGOS
        Place(
            R.string.nike_centre_for_art_and_culture,
            R.drawable.nike_centre_for_art_and_culture,
            R.string.nike_centre_for_art_and_culture_details,
            State.Lagos
        ),
        Place(
            R.string.lekki_conservation_centre,
            R.drawable.lekki_conservation_centre,
            R.string.lekki_conservation_centre_details,
            State.Lagos
        ),
        Place(
            R.string.freedom_park,
            R.drawable.freedom_park,
            R.string.freedom_park_details,
            State.Lagos
        ),
        Place(
            R.string.the_cathedral,
            R.drawable.the_cathedral,
            R.string.the_cathedral_details,
            State.Lagos
        ),
        Place(
            R.string.iga_idungaran,
            R.drawable.iga_idungaran,
            R.string.iga_idungaran_details,
            State.Lagos
        ),
        Place(
            R.string.national_arts_theatre,
            R.drawable.national_arts_theatre,
            R.string.national_arts_theatre_details,
            State.Lagos
        ),
//  KADUNA
        Place(
            R.string.kajuru_castle,
            R.drawable.kajuru_castle,
            R.string.kajuru_castle_details,
            State.Kaduna
        ),
        Place(
            R.string.gen__hassan_U__katsina_house,
            R.drawable.gen_hassan_u_katsina,
            R.string.gen__hassan_U__katsina_house_details,
            State.Kaduna
        ),
        Place(
            R.string.dupanah_world_of_beauty_spa,
            R.drawable.dupah_world_of_beauty,
            R.string.dupanah_world_of_beauty_spa_details,
            State.Kaduna
        ),
        Place(
            R.string.fifth_chukker_polo_and_resort,
            R.drawable.fifth_chukker_polo,
            R.string.fifth_chukker_polo_and_resort_details,
            State.Kaduna
        )

    )


    val defaultPlace = Place(
        placeName = -1,
        placeImage = -1,
        placeDetails = -1,
        state = State.Abuja
    )

    /**categories*/
    val stateList = listOf(
        StateDetails(
            R.string.Abuja,
            R.drawable.abuja_homepage,
            State.Abuja
        ),
        StateDetails(
            R.string.Lagos,
            R.drawable.lagos_homepage,
            State.Lagos
        ),
        StateDetails(
            R.string.kaduna,
            R.drawable.kaduna_homepage,
            State.Kaduna
        )

    )
}