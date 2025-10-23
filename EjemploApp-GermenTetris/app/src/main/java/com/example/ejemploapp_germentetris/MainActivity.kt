package com.example.ejemploapp_germentetris

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import model.Rectangulo

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val rectanguloView: View = findViewById(R.id.rectangulo)

        val rectangulo: Rectangulo = Rectangulo(ContextCompat.getColor(this, R.color.green), 100, 100)

        val btnArriba: Button = findViewById(R.id.btnArriba)
        val btnAbajo: Button = findViewById(R.id.btnAbajo)
        val btnIzquierda: Button = findViewById(R.id.btnIzquierda)
        val btnDerecha: Button = findViewById(R.id.btnDerecha)
        val btnCambiarTamanio: Button = findViewById(R.id.btnCambiarTamanio)
        val btnCambiarColor: Button = findViewById(R.id.btnCambiarColor)

        btnArriba.setOnClickListener {
            rectangulo.moverArriba()
            actualizarVista(rectangulo, rectanguloView)
        }

        btnAbajo.setOnClickListener {
            rectangulo.moverAbajo()
            actualizarVista(rectangulo, rectanguloView)
        }

        btnDerecha.setOnClickListener {
            rectangulo.moverDerecha()
            actualizarVista(rectangulo, rectanguloView)
        }

        btnIzquierda.setOnClickListener {
            rectangulo.moverIzquierda()
            actualizarVista(rectangulo, rectanguloView)
        }

        btnCambiarTamanio.setOnClickListener {
            rectangulo.cambiarTamanio(200, 200)
            actualizarVista(rectangulo, rectanguloView)
        }

        btnCambiarColor.setOnClickListener {
            rectangulo.color = (ContextCompat.getColor(this, R.color.orange))
            actualizarVista(rectangulo, rectanguloView)
        }

    }

    private fun actualizarVista(rectangulo: Rectangulo, rectanguloView: View){

        // Al rectanguloView la da el valor del rectangulo clase Rectangulo
        rectanguloView.layoutParams.width = rectangulo.ancho
        rectanguloView.layoutParams.height = rectangulo.alto

        rectanguloView.setBackgroundColor(rectangulo.color)

        rectanguloView.x = rectangulo.x.toFloat()
        rectanguloView.y = rectangulo.y.toFloat()

        // método para que tome efecto, solicita de nuevo el layout
        rectanguloView.requestLayout()

    }
}