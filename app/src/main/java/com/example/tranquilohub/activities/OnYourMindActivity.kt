package com.example.tranquilohub.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tranquilohub.OptionItem
import com.example.tranquilohub.R
import com.example.tranquilohub.navigation.Screen

class OnYourMindActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OnYourMindScreen(navController = null)
        }
    }
}

@Composable
fun OnYourMindScreen(navController: NavController?) {
    val selectedOption = remember { mutableStateOf("Managing anxiety & stress") }

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
                    text = "What's on your mind?",
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
                            popUpTo(Screen.OnYourMindScreen.route) { inclusive = true }
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

            Spacer(modifier = Modifier.height(30.dp))

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
                    text = "Choose one option for now. You can explore others later",
                    color = Color.White,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                // Radio button options
                OptionItem(
                    text = "Managing anxiety & stress",
                    isSelected = selectedOption.value == "Managing anxiety & stress"
                ) {
                    selectedOption.value = it
                }

                OptionItem(
                    text = "Sleeping soundly",
                    isSelected = selectedOption.value == "Sleeping soundly"
                ) {
                    selectedOption.value = it
                }

                OptionItem(
                    text = "Being more active",
                    isSelected = selectedOption.value == "Being more active"
                ) {
                    selectedOption.value = it
                }

                OptionItem(
                    text = "Staying focused",
                    isSelected = selectedOption.value == "Staying focused"
                ) {
                    selectedOption.value = it
                }

                OptionItem(
                    text = "Learn to meditate",
                    isSelected = selectedOption.value == "Learn to meditate"
                ) {
                    selectedOption.value = it
                }

                OptionItem(
                    text = "Invest in personal growth",
                    isSelected = selectedOption.value == "Invest in personal growth"
                ) {
                    selectedOption.value = it
                }

                Button(
                    onClick = { navController?.navigate(Screen.FeelingNowScreen.route) },
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
fun OnYourMindScreenPreview() {
    OnYourMindScreen(navController = null)
}