package com.example.u3_practica_guiada

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MenuScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Menú principal", style = MaterialTheme.typography.headlineMedium)

        Button(onClick = { navController.navigate(NavRoutes.Audio.route) }) {
            Icon(
                painter = painterResource(id = R.drawable.iconoaudio),
                contentDescription = "Audio"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Reproductor de Audio")
        }

        Button(onClick = { navController.navigate(NavRoutes.Video.route) }) {
            Icon(
                painter = painterResource(id = R.drawable.iconovideo),
                contentDescription = "Video"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Reproductor de Vídeo")
        }

        Button(onClick = { navController.navigate(NavRoutes.Camera.route) }) {
            Icon(
                painter = painterResource(id = R.drawable.iconocamara),
                contentDescription = "Cámara"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Cámara")
        }

        Button(onClick = { navController.navigate(NavRoutes.Recorder.route) }) {
            Icon(
                painter = painterResource(id = R.drawable.iconomicrofono),
                contentDescription = "Sonido"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Grabación de Sonido")
        }
    }
}
