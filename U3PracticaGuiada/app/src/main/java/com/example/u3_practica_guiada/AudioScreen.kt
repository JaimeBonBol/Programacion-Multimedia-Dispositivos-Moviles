package com.example.u3_practica_guiada

import android.media.MediaPlayer
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun AudioScreen(navController: NavController) {
    val context = LocalContext.current

    // MediaPlayer dentro de remember para no recrearlo
    val  mediaPlayer = remember {
        MediaPlayer.create(context, R.raw.audio1)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Reproductor de Audio", style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(20.dp))

        Button(onClick = {mediaPlayer.start()}) {Text("Play")}
        Button(onClick = {mediaPlayer.pause()}) {Text("Pause")}
        Button(onClick = {mediaPlayer.stop()}) {Text("Stop")}

        // Botón para volver al menú
        Button(onClick = { navController.navigate(NavRoutes.Menu.route) }) {
            Text("Volver al menú")
        }
    }
}