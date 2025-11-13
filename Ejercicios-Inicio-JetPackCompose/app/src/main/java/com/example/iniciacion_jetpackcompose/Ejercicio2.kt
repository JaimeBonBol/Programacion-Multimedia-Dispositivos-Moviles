package com.example.iniciacion_jetpackcompose

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun tarjetaPerfil(){
    // Columna principal centrada en la pantalla
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.fondo_principal))
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Fila que contione imagen y columna
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = colorResource(id = R.color.fondo_tarjeta),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.me),
                contentDescription = "Imagen ejemplo", // Obligatorio si no sale error
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(50.dp)), // Para redondear la imagen
            )

            // Columna al lado de la imagen
            Column (
                modifier = Modifier
                    .padding(start = 20.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center
            ) {
                // Nombre del usuaruio
                Text(
                    text = "Jaime Bonilla",
                    fontSize = 20.sp,
                    color = colorResource(id = R.color.azul_principal)
                )

                // Descripción
                Text(
                    text = "Estudiante 2º DAM"
                )

                // Fila anidadda con botones
                Row (
                    modifier = Modifier
                        .padding(top = 10.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    // Botón seguir a partir de la función que he creado para que cuando pulse apareca un toast
                    botonToast("Seguir")

                    // Botón mensaje a partir de la fucnción que he creado para que cuando pulse aparexca un toast
                    botonToast("Mensaje")
                }
            }
        }
    }
}

// Función para crear un boton con un Toast
@Composable
fun botonToast(textoBoton : String){
    // Obtener el contexto actual de la app, necesario para el tast
    val contexto = LocalContext.current

    // Crear el boton
    Button(
        onClick = {
            Toast.makeText(contexto, "Has pulsado el botón " + textoBoton + "!", Toast.LENGTH_LONG).show()
        },
        colors = ButtonDefaults.buttonColors(
            colorResource(id = R.color.teal_700)
        )
    ) {
        Text(
            text = textoBoton
        )
    }
}


@Preview(showBackground = true)
@Composable
fun previewTarjetaPerfil(){
    MaterialTheme {
        Surface {
            tarjetaPerfil()
        }
    }
}