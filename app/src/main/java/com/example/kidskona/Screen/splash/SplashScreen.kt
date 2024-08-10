package com.example.kidskona.Screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kidskona.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    // Navigate to the onboarding screen after a 2-second delay
    LaunchedEffect(true) {
        delay(2000)
        navController.navigate("onboarding") {
            // Removes the splash screen from the back stack
            popUpTo("splash") { inclusive = true }
        }
    }

    // Splash screen UI
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground), // Replace with your logo/image
                contentDescription = null,
                modifier = Modifier.size(128.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Welcome to CodeLearn",
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}
