package com.example.cvdurandgabin.pages.mainpage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cvdurandgabin.pages.mainpage.component.Bouton
import com.example.cvdurandgabin.pages.mainpage.component.Image
import com.example.cvdurandgabin.pages.mainpage.component.Lien
import com.example.cvdurandgabin.pages.mainpage.component.Titre
@Composable
fun Home(fullName:String, modifier: Modifier = Modifier, classes: WindowSizeClass){
    when (classes.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
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
            Box(contentAlignment = Alignment.BottomCenter, modifier = Modifier.fillMaxSize()) {
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