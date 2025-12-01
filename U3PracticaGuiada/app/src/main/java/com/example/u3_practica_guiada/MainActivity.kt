package com.example.u3_practica_guiada

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.u3_practica_guiada.ui.theme.U3PracticaGuiadaTheme
import com.tuapp.ui.screens.VideoScreen

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
