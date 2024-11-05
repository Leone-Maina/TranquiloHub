package com.example.tranquilohub.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tranquilohub.R
import com.example.tranquilohub.navigation.Screen

class Onboarding1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Onboarding1Screen(navController = null)
        }
    }
}

@Composable
fun Onboarding1Screen(navController: NavController?) {
    Surface(color = colorResource(id = R.color.background_color)) {
        // Row for Tranquilo text and Skip button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp,
                    vertical = 48.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Tranquilo text
            Text(
                text = "Tranquilo",
                color = Color.White,
                style = MaterialTheme.typography.titleMedium.copy(fontSize = 20.sp) // Increased font size
            )

            // Skip button as TextButton with underline
            TextButton(
                onClick = {
                    navController?.navigate(Screen.HomeScreen.route) {
                        //finish the activity
                        popUpTo(Screen.Onboarding1Screen.route) { inclusive = true }
                    }
                },
                colors = ButtonDefaults.textButtonColors(contentColor = colorResource(id = R.color.links_color)),
                modifier = Modifier.padding(bottom = 2.dp)
            ) {
                Text(
                    text = "Skip",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontSize = 20.sp,
                        textDecoration = TextDecoration.Underline
                    )
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(top = 48.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Illustration at the top
            Image(
                painter = painterResource(id = R.drawable.onboarding1_illustration),
                contentDescription = "Illustration",
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .aspectRatio(1f)
                    .padding(bottom = 24.dp)
            )

            // Floating form
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(10.dp, shape = RoundedCornerShape(16.dp))
                    .background(
                        color = colorResource(id = R.color.content_background_color),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Progress Indicator (Dots)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .size(12.dp)
                                .background(
                                    color = colorResource(id = R.color.progress_bar_color),
                                    shape = CircleShape
                                )
                        )

                        Spacer(modifier = Modifier.width(6.dp))

                        Box(
                            modifier = Modifier
                                .size(12.dp)
                                .background(
                                    color = Color.Gray,
                                    shape = CircleShape
                                )
                        )

                        Spacer(modifier = Modifier.width(6.dp))

                        Box(
                            modifier = Modifier
                                .size(12.dp)
                                .background(
                                    color = Color.Gray,
                                    shape = CircleShape
                                )
                        )
                    }

                    // Title
                    Text(
                        text = "Mindfulness Meditation",
                        style = MaterialTheme.typography.titleLarge.copy(
                            color = Color.White,
                            fontSize = 20.sp
                        ),
                        modifier = Modifier
                            .padding(top = 8.dp) // Reduce top padding
                            .align(Alignment.Start)
                    )

                    // Description
                    Text(
                        text = "Mindfulness meditation is just one of many types of meditation," +
                                " and it promotes presence in the now through focusing on breathing.",
                        color = Color.White,
                        fontSize = 14.sp,
                        modifier = Modifier
                            .padding(vertical = 8.dp) // Reduce vertical padding
                            .align(Alignment.Start),
                        textAlign = androidx.compose.ui.text.style.TextAlign.Start
                    )

                    Spacer(modifier = Modifier.height(50.dp))

                    // Next Button
                    Button(
                        onClick = { navController?.navigate(Screen.Onboarding2Screen.route) },
                        colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.button_color)),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(25.dp)
                    ) {
                        Text(
                            text = "Next",
                            color = Color.White,
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Onboarding1ScreenPreview() {
    Onboarding1Screen(navController = null)
}