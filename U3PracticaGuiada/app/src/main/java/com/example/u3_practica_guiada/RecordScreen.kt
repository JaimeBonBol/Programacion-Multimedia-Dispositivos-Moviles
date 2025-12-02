package com.example.u3_practica_guiada

import android.content.Intent
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun RecordScreen(navController: NavController) {

    // Launcher para grabar audio
    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {  }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Grabadora de sonido", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            val intent = Intent(MediaStore.Audio.Media.RECORD_SOUND_ACTION)
            launcher.launch(intent)
        }) {
            Icon(
                painter = painterResource(id = R.drawable.iconomicrofono),
                contentDescription = "Sonido"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Grabación de Sonido")
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
