package model

open class Rectangulo(var color: Int, var ancho: Int, var alto: Int) {

    // Coordenadas iniciales. Propiedades
    var x = 485
    var y = 1170

    // Construimos comportamientos
    fun moverArriba(){
        y-=50
    }

    fun moverAbajo(){
        y+=50
    }

    fun moverIzquierda(){
        x-=50
    }

    fun moverDerecha(){
        x+=50
    }

    fun cambiarTamanio(nuevoAncho: Int, nuevoAlto: Int){
        ancho = nuevoAncho
        alto = nuevoAlto
    }

}