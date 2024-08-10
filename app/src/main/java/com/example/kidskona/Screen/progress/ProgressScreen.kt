package com.example.kidskona.Screen.progress

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProgressScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Progress", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        ProgressItem("Lesson 1", progress = 100)
        ProgressItem("Lesson 2", progress = 50)
        // Add more progress items here
    }
}

@Composable
fun ProgressItem(title: String, progress: Int) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(text = title, style = MaterialTheme.typography.bodyLarge)
        LinearProgressIndicator(progress = progress / 100f, modifier = Modifier.fillMaxWidth())
        Text(text = "$progress%", style = MaterialTheme.typography.bodySmall)
    }
}
