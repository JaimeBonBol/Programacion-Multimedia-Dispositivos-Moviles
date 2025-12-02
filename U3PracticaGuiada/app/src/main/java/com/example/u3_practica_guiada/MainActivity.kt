package com.example.u3_practica_guiada

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.u3_practica_guiada.ui.theme.U3PracticaGuiadaTheme
import com.example.u3_practica_guiada.VideoScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = NavRoutes.Menu.route
            ) {
                composable(NavRoutes.Menu.route) { MenuScreen(navController) }
                composable(NavRoutes.Audio.route) { AudioScreen(navController) }
                composable(NavRoutes.Video.route) { VideoScreen(navController) }
                composable(NavRoutes.Camera.route) { CameraScreen(navController) }
                composable(NavRoutes.Recorder.route) { RecordScreen(navController) }
            }
        }
    }
}
