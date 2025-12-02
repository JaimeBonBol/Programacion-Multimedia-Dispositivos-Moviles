package com.example.u3_practica_guiada

import android.media.MediaPlayer
import android.net.Uri
import android.widget.MediaController
import android.widget.VideoView
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.example.u3_practica_guiada.R
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.u3_practica_guiada.NavRoutes

@Composable
fun VideoScreen(navController: NavController) {
    val context = LocalContext.current
    var videoView: VideoView? by remember { mutableStateOf(null) }

    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { ctx ->
            VideoView(ctx).apply {
                // Cargar el vídeo desde res/raw
                val videoUri = Uri.parse("android.resource://${ctx.packageName}/${R.raw.video1}")
                setVideoURI(videoUri)
                videoView = this
                // Iniciar reproducción automáticamente
                //start()
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
        Button(onClick = {videoView?.start()}) {
            Icon(
                painter = painterResource(id = R.drawable.iconoplay),
                contentDescription = "Play"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Play")
        }
        Button(onClick = {videoView?.pause()}) {
            Icon(
                painter = painterResource(id = R.drawable.iconopause),
                contentDescription = "Pause"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Pause")
        }
        Button(onClick = {videoView?.stopPlayback()}) {
            Icon(
                painter = painterResource(id = R.drawable.iconostop),
                contentDescription = "Stop"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Stop")
        }

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
