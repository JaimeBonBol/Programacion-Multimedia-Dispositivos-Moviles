package com.tuapp.ui.screens

import android.net.Uri
import android.widget.MediaController
import android.widget.VideoView
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.example.u3_practica_guiada.R
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.u3_practica_guiada.NavRoutes

@Composable
fun VideoScreen(navController: NavController) {
    val context = LocalContext.current

    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { ctx ->
            VideoView(ctx).apply {
                // Cargar el vídeo desde res/raw
                val videoUri = Uri.parse("android.resource://${ctx.packageName}/${R.raw.video1}")
                setVideoURI(videoUri)

                /*// Añadir controles de reproducción
                val mediaController = MediaController(ctx)
                mediaController.setAnchorView(this)
                setMediaController(mediaController)*/

                // Iniciar reproducción automáticamente
                start()
            }

        }

    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        // Botón para volver al menú
        Button(onClick = { navController.navigate(NavRoutes.Menu.route) }) {
            Text("Volver al menú")
        }
    }
}
