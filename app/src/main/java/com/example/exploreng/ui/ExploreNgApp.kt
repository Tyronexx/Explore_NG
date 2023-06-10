package com.example.exploreng.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.exploreng.R
import com.example.exploreng.data.LocalPlaceProvider
import com.example.exploreng.data.Screen
import com.example.exploreng.data.StateDetails

//var states = listOf<State>()


//routes
//enum class PlacesScreenNav(
//    @StringRes val title:Int
//) {
//    States(title = R.string.states),
//    Places(title = R.string.places),
//}

/*
@Composable
private fun ExploreNgHomeScreenTopBar(
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier,
//    currentScreen:PlacesScreenNav
){
    TopAppBar(
        title = { Text(text = stringResource(id = currentScreen.title)) },
        navigationIcon = {
            if (canNavigateBack){
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        },
        modifier = modifier
    )
}

*/

@Composable
fun ExploreNgApp(
//    viewModel: ExploreNgViewModel = viewModel(),
    navController: NavHostController = rememberNavController(),
){
//    val backStackEntry by navController.currentBackStackEntryAsState()
//    val currentScreen = PlacesScreenNav.valueOf(
//        backStackEntry?.destination?.route?: PlacesScreenNav.States.name
//    )
//
//    Scaffold(
//        topBar = {
//            ExploreNgHomeScreenTopBar(
//                canNavigateBack = navController.previousBackStackEntry != null,
//                navigateUp = { navController.navigateUp() },
//                currentScreen = currentScreen
//            )
//        }
//    ) { innerPadding ->
//
//
//    }

    NavHost(
        navController = navController,
        startDestination = Screen.StatesScreen.route
    ){
        composable(
            route = Screen.StatesScreen.route
        ){
            StatesScreen(navController = navController)
        }

        composable(
            route = Screen.PlacesScreen.route + "/{category_type}",   //todo(rename)
            arguments = listOf(
                navArgument("category_type"){ //todo(rename)
                    type = NavType.StringType
                    defaultValue = "Abuja"
                    nullable = true
                }
            )
        ){entry ->
            PlacesScreen(
                navController = navController,
                stateString = entry.arguments?.getString("category_type")   //todo(rename)
            )
        }

        composable(
            route = Screen.DetailsScreen.route + "/{place_desc}/{place_img}/{place_name}",   //todo(rename)
            arguments = listOf(
                navArgument("place_desc"){
                    type = NavType.StringType
                    defaultValue = "None"
                    nullable = false
                },
                navArgument("place_img"){
                    type = NavType.StringType
                    defaultValue = "None"
                    nullable = false
                },
                navArgument("place_name"){
                    type = NavType.StringType
                    defaultValue = "None"
                    nullable = false
                }

            )
        ){
            PlaceDetailsScreen(
                detailsRes = it.arguments?.getString("place_desc"),
                imageRes = it.arguments?.getString("place_img"),
                nameRes = it.arguments?.getString("place_name")
            )
        }
    }
}