package com.example.tranquilohub.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tranquilohub.activities.ExerciseScreen
import com.example.tranquilohub.activities.FeelingNowScreen
import com.example.tranquilohub.activities.HomeScreen
import com.example.tranquilohub.activities.OnYourMindScreen
import com.example.tranquilohub.activities.Onboarding1Screen
import com.example.tranquilohub.activities.Onboarding2Screen
import com.example.tranquilohub.activities.OtpVerificationScreen
import com.example.tranquilohub.activities.SignInScreen
import com.example.tranquilohub.activities.SplashScreen
import com.example.tranquilohub.activities.StartScreen

@Composable
fun TranquiloHub() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.SplashScreen.route) {
        composable(Screen.SplashScreen.route) { SplashScreen(navController) }
        composable(Screen.SignInScreen.route) { SignInScreen(navController) }
        composable(Screen.OtpVerificationScreen.route) { OtpVerificationScreen(navController) }
        composable(Screen.Onboarding1Screen.route) { Onboarding1Screen(navController) }
        composable(Screen.Onboarding2Screen.route) { Onboarding2Screen(navController) }
        composable(Screen.StartScreen.route) { StartScreen(navController) }
        composable(Screen.OnYourMindScreen.route) { OnYourMindScreen(navController) }
        composable(Screen.FeelingNowScreen.route) { FeelingNowScreen(navController) }
        composable(Screen.ExerciseScreen.route) { ExerciseScreen(navController) }
        composable(Screen.HomeScreen.route) { HomeScreen(navController) }
    }
}