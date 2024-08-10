package com.example.kidskona

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kidskona.Screen.lessons.LessonsScreen
import com.example.kidskona.Screen.onboarding.OnboardingScreen
import com.example.kidskona.Screen.practice.PracticeScreen
import com.example.kidskona.Screen.profile.ProfileScreen
import com.example.kidskona.Screen.progress.ProgressScreen
import com.example.kidskona.Screen.signin.SignInScreen
import com.example.kidskona.Screen.signup.SignUpScreen
import com.example.kidskona.Screen.splash.SplashScreen
import com.example.kidskona.ui.theme.KidsKonaTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KidsKonaTheme {
                MainScreen()
                }
            }
        }
    }



@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Spacer(Modifier.height(12.dp))
                DrawerItem(
                    icon = ImageVector.vectorResource(id = R.drawable.ic_lessons),
                    label = "Lessons",
                    onClick = {
                        scope.launch { drawerState.close() }
                        navController.navigate("lessons")
                    }
                )
                DrawerItem(
                    icon = ImageVector.vectorResource(id = R.drawable.ic_practice),
                    label = "Practice",
                    onClick = {
                        scope.launch { drawerState.close() }
                        navController.navigate("practice")
                    }
                )
                DrawerItem(
                    icon = ImageVector.vectorResource(id = R.drawable.ic_progress),
                    label = "Progress",
                    onClick = {
                        scope.launch { drawerState.close() }
                        navController.navigate("progress")
                    }
                )
                DrawerItem(
                    icon = ImageVector.vectorResource(id = R.drawable.ic_profile),
                    label = "Profile",
                    onClick = {
                        scope.launch { drawerState.close() }
                        navController.navigate("profile")
                    }
                )
            }
        },
        content = {
            NavHost(navController, startDestination = "splash") {
                composable("splash") { SplashScreen(navController) }
                composable("onboarding") { OnboardingScreen(navController) }
                composable("signup") { SignUpScreen(navController) }
                composable("signin") { SignInScreen(navController) }
                composable("lessons") { LessonsScreen() }
                composable("practice") { PracticeScreen() }
                composable("progress") { ProgressScreen() }
                composable("profile") { ProfileScreen() }
            }
        }
    )
}

@Composable
fun DrawerItem(icon: ImageVector, label: String, onClick: () -> Unit) {
    NavigationDrawerItem(
        icon = { Icon(imageVector = icon, contentDescription = null) },
        label = { Text(label) },
        selected = false,
        onClick = onClick,
        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
    )
}