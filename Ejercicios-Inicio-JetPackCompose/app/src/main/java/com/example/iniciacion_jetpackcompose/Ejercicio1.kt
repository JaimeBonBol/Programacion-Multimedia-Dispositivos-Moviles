package com.example.iniciacion_jetpackcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Ejercicio1 {
}

@Composable
fun miPracticaConAnidamientos(){
    // Columna principal que ocupa toda la pantalla
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.fondo_principal))
            .padding(top = 20.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Parte 1, un título.
        Text(
            text = "Práctica de Filas, Columnas y Anidamientos",
            fontSize = 20.sp,
            color = colorResource(id = R.color.black)
        )

        // PArte 2, fila principal
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = R.color.white))
                .padding(8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            // Columna interna izquierda
            Column(
                modifier = Modifier
                    .padding(10.dp, 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Columna Izquierda"
                )
                Text(
                    text = "Elemento A"
                )
                Text(
                    text = "Elemento B"
                )
            }

            // Columna interna derecha
            Column(
                modifier = Modifier
                    .padding(10.dp, 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Columna derecha"
                )

                Row(
                    // Deja un espacio de 10dp entre los elementos
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = "1"
                    )
                    Text(
                        text = "2"
                    )
                    Text(
                        text = "3"
                    )
                }
            }
        }

        // Parte 3, fila inferior
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = R.color.teal_200))
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = "Opción 1",
                color = colorResource(id = R.color.white)
            )
            Text(
                text = "Opción 2",
                color = colorResource(id = R.color.black)
            )
            Text(
                text = "Opción 3",
                color = colorResource(id = R.color.purple_200)
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun previewMiPracticaConAnidamientos(){
    MaterialTheme {
        Surface {
            miPracticaConAnidamientos()
        }
    }
}