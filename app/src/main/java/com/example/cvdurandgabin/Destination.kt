package com.example.cvdurandgabin

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.ui.graphics.vector.ImageVector


sealed class Destination(val destination: String, val label: String, val icon: ImageVector) {
    object Home : Destination("home", "Home", Icons.Filled.Person)
    object Film : Destination("film", "Liste des films", Icons.Filled.PlayArrow)
    object Serie : Destination("serie", "Liste des séries", Icons.Filled.Info)
    object Acteur : Destination("acteur", "Liste des acteurs", Icons.Filled.Face)
    object FilmDetail : Destination("film/{movieId}", "Detail de film", Icons.Filled.Info)
    object SerieDetail : Destination("serie/{serieId}", "Detail de serie", Icons.Filled.Info)
    object ActeurDetail : Destination("acteur/{actorId}", "Detail d'acteur", Icons.Filled.Info)
}