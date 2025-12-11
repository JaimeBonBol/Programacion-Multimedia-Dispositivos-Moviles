package com.example.u3_practica_guiada

import android.content.Intent
import android.graphics.Bitmap
import android.provider.MediaStore
import android.widget.ImageView
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController

@Composable
fun CameraScreen(navController: NavController) {

    // Variable de estado para guardar la foto capturada
    var imageBitmap by remember { mutableStateOf<Bitmap?>(null) }

    // Preparamos el lanzador que recibirá el resultado de la cámara
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        // Si el resultado es OK, recuperamos la miniatura de la foto
        if (result.resultCode == android.app.Activity.RESULT_OK) {
            val bitmap = result.data?.extras?.get("data") as? Bitmap
            imageBitmap = bitmap
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Cámara", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(20.dp))

        Button(onClick = {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            launcher.launch(intent)
        }) {
            Icon(
                painter = painterResource(id = R.drawable.iconocamara),
                contentDescription = "Cámara"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Abrir cámara")
        }

        // Si hay foto capturada, la mostramos en pantalla
        imageBitmap?.let {
            Spacer(Modifier.height(20.dp))
            Text("Foto capturada:")
            Image(
                bitmap = it.asImageBitmap(),
                contentDescription = "Foto",
                modifier = Modifier.padding(16.dp)
            )
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
