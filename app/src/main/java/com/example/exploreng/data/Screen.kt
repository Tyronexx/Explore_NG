package com.example.exploreng.data

sealed class Screen(                       //routes
    val route: String
){
    object StatesScreen:  Screen("states_screen")
    object PlacesScreen: Screen("places_screen")
    object DetailsScreen: Screen("details_screen")

    fun withArgs(vararg args: String): String{          //todo(study)
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
