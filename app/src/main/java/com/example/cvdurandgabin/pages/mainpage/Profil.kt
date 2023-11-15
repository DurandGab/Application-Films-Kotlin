package com.example.cvdurandgabin.pages.mainpage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.cvdurandgabin.Destination


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.cvdurandgabin.models.MainViewModel
import com.example.cvdurandgabin.pages.acteur.acteur
import com.example.cvdurandgabin.pages.film.film
import com.example.cvdurandgabin.pages.mainpage.component.Bouton
import com.example.cvdurandgabin.pages.mainpage.component.Image
import com.example.cvdurandgabin.pages.mainpage.component.Lien
import com.example.cvdurandgabin.pages.mainpage.component.Titre
import com.example.cvdurandgabin.pages.série.serie
import com.example.cvdurandgabin.ui.theme.CVDurandGabinTheme

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun Greeting(fullName: String, modifier: Modifier = Modifier, classes: WindowSizeClass, viewModel: MainViewModel) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val destinations = listOf(Destination.Film, Destination.Serie, Destination.Acteur)
    Scaffold(
        bottomBar = {
            if (currentDestination?.route != Destination.Home.destination)
                BottomNavigation {
                    destinations.forEach { screen ->
                        BottomNavigationItem(
                            icon = { Icon(screen.icon, contentDescription = null) },
                            label = { Text(screen.label) },
                            selected =
                            currentDestination?.hierarchy?.any { it.route == screen.destination } == true,
                            onClick = { navController.navigate(screen.destination) })
                    }
                }
        }) { innerPadding ->
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
            composable(Destination.Film.destination) { film(viewModel) }
            composable(Destination.Acteur.destination) { acteur() }
            composable(Destination.Serie.destination) { serie() }
        }
    }
}