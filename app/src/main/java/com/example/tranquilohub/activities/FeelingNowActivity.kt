package com.example.tranquilohub.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tranquilohub.OptionItem
import com.example.tranquilohub.R
import com.example.tranquilohub.navigation.Screen

class FeelingNowActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FeelingNowScreen(navController = null)
        }
    }
}

@Composable
fun FeelingNowScreen(navController: NavController?) {
    val selectedOption = remember { mutableStateOf("Very Relaxed") }

    Surface(color = colorResource(id = R.color.background_color)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Top,
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(
                    onClick = { navController?.popBackStack() }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "How you're feeling now?",
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium.copy(fontSize = 20.sp),
                    modifier = Modifier.weight(2f),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )

                Spacer(modifier = Modifier.weight(1f))

                TextButton(
                    onClick = {
                        navController?.navigate(Screen.HomeScreen.route) {
                            //finish the activity
                            popUpTo(Screen.FeelingNowScreen.route) { inclusive = true }
                        }
                    },
                    colors = ButtonDefaults.textButtonColors(contentColor = colorResource(id = R.color.links_color))
                ) {
                    Text(
                        text = "Skip",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = 16.sp,
                            textDecoration = TextDecoration.Underline
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(50.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = colorResource(id = R.color.content_background_color),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(
                        top = 8.dp,
                        bottom = 16.dp,
                        start = 16.dp,
                        end = 16.dp
                    )
            ) {
                Text(
                    text = "Take a moment to check in with yourself. How are you feeling now?",
                    color = Color.White,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                OptionItem(
                    text = "Very Relaxed",
                    isSelected = selectedOption.value == "Very Relaxed"
                ) {
                    selectedOption.value = it
                }

                OptionItem(
                    text = "Relaxed",
                    isSelected = selectedOption.value == "Relaxed"
                ) {
                    selectedOption.value = it
                }

                OptionItem(
                    text = "Neutral",
                    isSelected = selectedOption.value == "Neutral"
                ) {
                    selectedOption.value = it
                }

                OptionItem(
                    text = "Anxious",
                    isSelected = selectedOption.value == "Anxious"
                ) {
                    selectedOption.value = it
                }

                OptionItem(
                    text = "Very Anxious",
                    isSelected = selectedOption.value == "Very Anxious"
                ) {
                    selectedOption.value = it
                }

                Button(
                    onClick = { navController?.navigate(Screen.ExerciseScreen.route) },
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.button_color)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                        .height(56.dp),
                    shape = RoundedCornerShape(50)
                ) {
                    Text(
                        text = "Continue",
                        color = Color.White,
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FeelingNowScreenPreview() {
    FeelingNowScreen(navController = null)
}