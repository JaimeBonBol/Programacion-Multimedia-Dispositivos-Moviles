package model

import android.R
import android.graphics.Color

class RectanguloBorder(color: Int, ancho:Int, alto:Int, var bordeColor: Int= Color.BLACK):
    Rectangulo(color, ancho, alto) {

    fun cambiarColorBorder(nuevoColorBode : Int){
        bordeColor = nuevoColorBode
    }
}