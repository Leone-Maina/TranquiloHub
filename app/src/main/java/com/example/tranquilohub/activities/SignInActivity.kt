package com.example.tranquilohub.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tranquilohub.R
import com.example.tranquilohub.navigation.Screen
import com.example.tranquilohub.ui.theme.TranquiloHubTheme

class SignInActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SignInScreen(navController = null)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(navController: NavController?) {
    // State variable to hold the mobile number input
    val mobileNumber = remember { mutableStateOf("") }

    Surface(color = colorResource(id = R.color.background_color)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Illustration at the top
            Image(
                painter = painterResource(id = R.drawable.auth_illustration),
                contentDescription = "Illustration",
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .aspectRatio(1f)
                    .padding(bottom = 32.dp)
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
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    // Mobile number TextField
                    OutlinedTextField(
                        value = mobileNumber.value,
                        onValueChange = { mobileNumber.value = it },
                        label = {
                            Text(
                                "Enter your mobile number",
                                color = Color.Gray
                            )
                        },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp),
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.Blue,
                            unfocusedBorderColor = Color.Gray,
                            focusedLabelColor = Color.Gray,
                            unfocusedLabelColor = Color.Gray
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Sign In Button
                    Button(
                        onClick = { navController?.navigate(Screen.OtpVerificationScreen.route) },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.button_color)),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = "Sign In",
                            color = Color.White,
                            fontSize = 16.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // OR Divider
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Divider(
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 16.dp),
                            color = Color.Gray
                        )

                        Text(
                            text = "or sign in with",
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(horizontal = 8.dp),
                            color = Color.White
                        )

                        Divider(
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 16.dp),
                            color = Color.Gray
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Continue with Google Button
                    Button(
                        onClick = { /* Handle input change */ },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.button_color)),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.google_icon),
                            contentDescription = "Google icon",
                            modifier = Modifier.size(24.dp)
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = "Continue with Google",
                            color = Color.White,
                            fontSize = 16.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Continue with Apple Button
                    Button(
                        onClick = { /* Handle input change */ },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.button_color)),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.apple_icon),
                            contentDescription = "Apple icon",
                            modifier = Modifier.size(24.dp)
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = "Continue with Apple",
                            color = Color.White,
                            fontSize = 16.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    val linkColor = colorResource(id = R.color.links_color)

                    val termsAndPrivacyPolicyText = buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color.White)) {
                            append("By signing up, you agree to our ")
                        }

                        pushStringAnnotation(
                            tag = "terms",
                            annotation = "terms"
                        )

                        withStyle(
                            style = SpanStyle(
                                color = linkColor,
                                textDecoration = TextDecoration.Underline
                            )
                        ) {
                            append("Terms of Service")
                        }

                        pop()

                        withStyle(style = SpanStyle(color = Color.White)) {
                            append(" and acknowledge that our ")
                        }

                        pushStringAnnotation(
                            tag = "privacy",
                            annotation = "privacy"
                        )

                        withStyle(
                            style = SpanStyle(
                                color = linkColor,
                                textDecoration = TextDecoration.Underline
                            )
                        ) {
                            append("Privacy Policy")
                        }

                        pop()

                        withStyle(style = SpanStyle(color = Color.White)) {
                            append(" applies to you.")
                        }
                    }

                    ClickableText(
                        text = termsAndPrivacyPolicyText,
                        onClick = { offset ->
                            termsAndPrivacyPolicyText.getStringAnnotations(
                                tag = "terms",
                                start = offset,
                                end = offset
                            ).firstOrNull()?.let {
                                // Handle click for Terms of Service
                                Toast.makeText(
                                    navController?.context,
                                    "Terms of Service clicked",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }

                            termsAndPrivacyPolicyText.getStringAnnotations(
                                tag = "privacy",
                                start = offset,
                                end = offset
                            ).firstOrNull()?.let {
                                // Handle click for Privacy Policy
                                Toast.makeText(
                                    navController?.context,
                                    "Privacy Policy clicked",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignInScreenPreview() {
    TranquiloHubTheme {
        SignInScreen(navController = null)
    }
}