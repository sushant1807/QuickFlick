package com.saika.quickflick.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.saika.quickflick.presentation.ui.FlickerDetailView
import com.saika.quickflick.presentation.ui.FlickerSearchView
import com.saika.quickflick.ui.theme.QuickFlickTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuickFlickTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "imageSearch") {
        composable("imageSearch") {
            FlickerSearchView(navController)
        }
        composable(
            "imageDetail/{title}/{imageUrl}/{author}/{publishedDate}/{description}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType },
                navArgument("imageUrl") { type = NavType.StringType },
                navArgument("author") { type = NavType.StringType },
                navArgument("publishedDate") { type = NavType.StringType },
                navArgument("description") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            FlickerDetailView(
                title = backStackEntry.arguments?.getString("title") ?: "",
                imageUrl = backStackEntry.arguments?.getString("imageUrl") ?: "",
                author = backStackEntry.arguments?.getString("author") ?: "",
                publishedDate = backStackEntry.arguments?.getString("publishedDate") ?: "",
                description = backStackEntry.arguments?.getString("description") ?: "",
                navController
            )
        }
    }
}
