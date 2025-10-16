package com.example.ejercicio1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val num1 = findViewById<EditText>(R.id.num1)
        val num2 = findViewById<EditText>(R.id.num2)
        val textoResultado = findViewById<TextView>(R.id.textoResultado)
        val btnSumar = findViewById<Button>(R.id.btnSumar)

        btnSumar.setOnClickListener {
            // Obtener los valores como texto y convertirlos a números
            val valor1 = num1.text.toString().toIntOrNull() ?: 0
            val valor2 = num2.text.toString().toIntOrNull() ?: 0

            val resultado = valor1 + valor2
            textoResultado.text = "Resultado: $resultado"
        }
    }
}