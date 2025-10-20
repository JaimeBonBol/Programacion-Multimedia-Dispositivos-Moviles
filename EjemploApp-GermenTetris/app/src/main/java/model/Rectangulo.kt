package model

class Rectangulo(var color: Int, var ancho: Int, var alto: Int) {

    // Coordenadas iniciales. Propiedades
    var x = 0
    var y = 0

    // Construimos comportamientos
    fun moverArriba(){
        y+=50
    }

    fun moverAbajo(){
        y-=50
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

    fun cambiarColor(nuevoColor: Int){
        color = nuevoColor
    }

}