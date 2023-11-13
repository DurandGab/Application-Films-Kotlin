package com.example.cvdurandgabin

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector


sealed class Destination(val destination: String, val label: String, val icon: ImageVector) {
    object Film : Destination("film", "Liste de films", Icons.Filled.Person)
    object Serie : Destination("serie", "Liste des séries", Icons.Filled.Edit)
    object Acteur : Destination("acteur", "Liste des acteurs", Icons.Filled.Edit)
}