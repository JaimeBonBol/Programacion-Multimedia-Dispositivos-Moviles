package com.example.ejemploapp_germentetris

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import model.Rectangulo
import model.RectanguloBorder
import kotlin.math.absoluteValue
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val rectanguloView: View = findViewById(R.id.rectangulo)
        rectanguloView.post{
            val Xinicial = rectanguloView.x.toInt()
            val Yinicial = rectanguloView.y.toInt()
            val anchoInicial = rectanguloView.width
            val altoInicial = rectanguloView.height

            /*val rectangulo: Rectangulo = Rectangulo(
                ContextCompat.getColor(this, R.color.green),
                anchoInicial,
                altoInicial
            ).apply {
                x = Xinicial
                y = Yinicial
            }*/

            val rectangulo: RectanguloBorder = RectanguloBorder(
                ContextCompat.getColor(this, R.color.green),
                anchoInicial,
                altoInicial,
            ).apply {
                x = Xinicial
                y = Yinicial
                bordeColor = ContextCompat.getColor(this@MainActivity, R.color.black)
            }

            val btnArriba: Button = findViewById(R.id.btnArriba)
            val btnAbajo: Button = findViewById(R.id.btnAbajo)
            val btnIzquierda: Button = findViewById(R.id.btnIzquierda)
            val btnDerecha: Button = findViewById(R.id.btnDerecha)
            val btnCambiarTamanio: Button = findViewById(R.id.btnCambiarTamanio)
            val btnCambiarColor: Button = findViewById(R.id.btnCambiarColor)
            val btnCambiarColorBordes: Button = findViewById(R.id.btnCambiarColorBorde)

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
                rectangulo.color = generarColorAleatorio()
                actualizarVista(rectangulo, rectanguloView)
            }
            btnCambiarColorBordes.setOnClickListener {
                rectangulo.cambiarColorBorder(generarColorAleatorio())
                actualizarVista(rectangulo, rectanguloView)
            }
        }

    }

    private fun actualizarVista(rectangulo: Rectangulo, rectanguloView: View){

        // Al rectanguloView la da el valor del rectangulo clase Rectangulo
        rectanguloView.layoutParams.width = rectangulo.ancho
        rectanguloView.layoutParams.height = rectangulo.alto

        val drawable = GradientDrawable()

        drawable.setColor(rectangulo.color)
        drawable.setStroke(10, rectangulo.color)

        //rectanguloView.setBackgroundColor(rectangulo.color)
        rectanguloView.background = drawable

        rectanguloView.x = rectangulo.x.toFloat()
        rectanguloView.y = rectangulo.y.toFloat()

        // método para que tome efecto, solicita de nuevo el layout
        rectanguloView.requestLayout()

    }

    private fun generarColorAleatorio() : Int{
        val rojo = Random.nextInt()
        val verde = Random.nextInt()
        val azul = Random.nextInt()

        return Color.rgb(rojo, verde, azul);
    }
}