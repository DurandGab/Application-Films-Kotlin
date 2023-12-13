package com.example.cvdurandgabin.pages.mainpage

import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import com.example.cvdurandgabin.models.TmdbMovieDetail

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class, ExperimentalMaterial3Api::class)
@Composable
fun Greeting(fullName: String, modifier: Modifier = Modifier, classes: WindowSizeClass, viewModel: MainViewModel) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    var searchTerm by remember { mutableStateOf("") }
    val destinations = listOf(Destination.Film, Destination.Serie, Destination.Acteur)
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    OutlinedTextField(value = searchTerm, onValueChange = {
                        searchTerm = it
                    },
                        label = {Text("rechercher des films")},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                },
                actions = {
                    // Bouton de recherche dans la TopAppBar
                    IconButton(
                        onClick = {
                            viewModel.getSearchMovies(searchTerm)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Rechercher"
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
    val searchMovieResult by viewModel.movies.collectAsState()

    if (searchMovieResult != null) {
        // Utilisez searchMovieResult.results pour afficher la liste des films résultants
        for (movie in searchMovieResult) {
            // Affichez chaque film dans votre UI
        }
    }
}