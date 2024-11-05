package com.example.tranquilohub.navigation

sealed class Screen (val route: String) {
    data object SplashScreen : Screen("splash_screen")
    data object SignInScreen : Screen("sign_in_screen")
    data object OtpVerificationScreen : Screen("otp_verification_screen")
    data object Onboarding1Screen : Screen("onboarding1_screen")
    data object Onboarding2Screen: Screen("onboarding2_screen")
    data object StartScreen : Screen("start_screen")
    data object OnYourMindScreen : Screen("on_your_mind_screen")
    data object FeelingNowScreen : Screen("feeling_now_screen")
    data object ExerciseScreen : Screen("exercise_screen")
    data object HomeScreen : Screen("home_screen")
}