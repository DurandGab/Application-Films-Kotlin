package com.example.cvdurandgabin.pages.mainpage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import com.example.cvdurandgabin.Destination
import com.example.cvdurandgabin.pages.acteur.acteur
import com.example.cvdurandgabin.pages.film.film
import com.example.cvdurandgabin.pages.mainpage.component.Bouton
import com.example.cvdurandgabin.pages.mainpage.component.Image
import com.example.cvdurandgabin.pages.mainpage.component.Lien
import com.example.cvdurandgabin.pages.mainpage.component.Titre
import com.example.cvdurandgabin.pages.série.serie
import com.example.cvdurandgabin.ui.theme.CVDurandGabinTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CVDurandGabinTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val windowSizeClass = calculateWindowSizeClass(this)
                    Greeting(fullName = "Gabin", classes = windowSizeClass)
                }
            }
        }
    }
}
@Composable
fun Greeting(fullName:String, modifier: Modifier = Modifier, classes: WindowSizeClass) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val destinations = listOf(Destination.Film, Destination.Serie, Destination.Acteur)
    Scaffold(
        bottomBar = { BottomNavigation {
            destinations.forEach { screen ->
                BottomNavigationItem(
                    icon = { Icon(screen.icon, contentDescription = null) },
                    label = { Text(screen.label) },
                    selected =
                    currentDestination?.hierarchy?.any { it.route == screen.destination } == true,
                    onClick = { navController.navigate(screen.destination) })
            }}
        }) { innerPadding ->
        NavHost(navController, startDestination = Destination.Film.destination,
            Modifier.padding(innerPadding)) {
            composable(Destination.Film.destination) { film() }
            composable(Destination.Acteur.destination) { acteur() }
            composable(Destination.Serie.destination) { serie() }
        }
    }
    val classHauteur = classes.heightSizeClass
    val classLargeur = classes.widthSizeClass
    when (classes.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            Box(contentAlignment = Alignment.Center) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(modifier)
                    Titre(modifier)
                    Spacer(modifier = Modifier.height(30.dp))
                    Lien(modifier)
                    Bouton(modifier)
                }

            }
        }
        else -> {
            Box(contentAlignment = Alignment.BottomCenter) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Column(verticalArrangement = Arrangement.SpaceEvenly) {
                        Image(modifier)
                        Lien(modifier)
                    }
                    Column(
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Titre(modifier)
                    }

                }
                Spacer(modifier = Modifier.height(10.dp))
                Bouton(modifier)
            }
        }
    }
}