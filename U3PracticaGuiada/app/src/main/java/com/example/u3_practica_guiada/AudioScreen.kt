package com.example.u3_practica_guiada

import android.media.MediaPlayer
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun AudioScreen(navController: NavController) {
    val context = LocalContext.current
    var volume by remember { mutableStateOf(1f) }

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

        Button(onClick = {mediaPlayer.start()}) {
            Icon(
                painter = painterResource(id = R.drawable.iconoplay),
                contentDescription = "Play"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Play")
        }
        Button(onClick = {mediaPlayer.pause()}) {
            Icon(
                painter = painterResource(id = R.drawable.iconopause),
                contentDescription = "Pause"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Pause")
        }
        Button(onClick = {mediaPlayer.stop()}) {
            Icon(
                painter = painterResource(id = R.drawable.iconostop),
                contentDescription = "Stop"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Stop")
        }
        Slider(
            value = volume,
            onValueChange = {
                volume = it
                mediaPlayer.setVolume(volume, volume)
            },
            valueRange = 0f..1f
        )

        // Botón para volver al menú
        Button(onClick = { navController.navigate(NavRoutes.Menu.route) }){
            Icon(
                painter = painterResource(id = R.drawable.iconovolver),
                contentDescription = "Volver"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Volver al menú")
        }
    }
}