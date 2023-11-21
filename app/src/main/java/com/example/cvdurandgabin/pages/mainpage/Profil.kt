package com.example.cvdurandgabin.pages.mainpage

import com.example.cvdurandgabin.Destination


import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.cvdurandgabin.models.MainViewModel
import com.example.cvdurandgabin.pages.acteur.acteur
import com.example.cvdurandgabin.pages.acteur.components.DetailActor
import com.example.cvdurandgabin.pages.film.components.DetailFilm
import com.example.cvdurandgabin.pages.film.film
import com.example.cvdurandgabin.pages.série.Components.DetailSerie
import com.example.cvdurandgabin.pages.série.serie
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class, ExperimentalMaterial3Api::class)
@Composable
fun Greeting(fullName: String, modifier: Modifier = Modifier, classes: WindowSizeClass, viewModel: MainViewModel) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val destinations = listOf(Destination.Film, Destination.Serie, Destination.Acteur)
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.statusBarsPadding(),
                backgroundColor = MaterialTheme.colorScheme.primaryContainer,
                title = {
                    Text("Application Film", color = MaterialTheme.colorScheme.primary)
                },
                actions = {
                    // Search icon
                    IconButton(
                        onClick = {
                            // Handle search icon click
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search"
                        )
                    }

                    // Favorite icon
                    IconButton(
                        onClick = {
                            // Handle favorite icon click
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "Favorite"
                        )
                    }
                }
            )

        },
        bottomBar = {
            if (currentDestination?.route != Destination.Home.destination)
                BottomNavigation(
                    backgroundColor = /* Votre couleur ici */ Color(0xff00ffd4)
                ) {
                    destinations.forEach { screen ->
                        BottomNavigationItem(
                            icon = { Icon(screen.icon, contentDescription = null) },
                            label = { Text(screen.label) },
                            selected = currentDestination?.hierarchy?.any { it.route == screen.destination } == true,
                            onClick = { navController.navigate(screen.destination) }
                        )
                    }
                }
        }
    )
    { innerPadding ->
        NavHost(
            navController, startDestination = Destination.Home.destination,
            Modifier.padding(innerPadding)
        ) {
            composable(Destination.Home.destination) {
                Home(
                    fullName = "Gabin Durand",
                    classes = classes,
                ) { navController.navigate(Destination.Film.destination) }
            }
            composable(Destination.Film.destination) { film(viewModel){ id-> navController.navigate("film/${id}") } }
            composable("film/{movieId}") { backStackEntry ->
                DetailFilm(backStackEntry.arguments?.getString("movieId")!!.toInt(), viewModel) }
            composable(Destination.Acteur.destination) { acteur(viewModel) {id-> navController.navigate("acteur/${id}")} }
            composable("acteur/{actorId}") { backStackEntry ->
                DetailActor(backStackEntry.arguments?.getString("actorId")!!.toInt(), viewModel) }
            composable(Destination.Serie.destination) { serie(viewModel) {id-> navController.navigate("serie/${id}")} }
            composable("serie/{serieId}") { backStackEntry ->
                DetailSerie(backStackEntry.arguments?.getString("serieId")!!.toInt(), viewModel) }

        }
    }
}