package com.example.u3_practica_guiada

sealed class NavRoutes(val route: String) {
    object Menu : NavRoutes("menu")
    object Audio : NavRoutes("audio")
    object Video : NavRoutes("video")
    object Camera : NavRoutes("camera")
    object Recorder : NavRoutes("recorder")
}