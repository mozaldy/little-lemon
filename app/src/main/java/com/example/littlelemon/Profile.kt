package com.example.littlelemon

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.ui.theme.KarlaFamily
import com.example.littlelemon.ui.theme.SecondaryColor


@Composable
fun ProfileScreen(navController: NavHostController) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    val context = LocalContext.current
    val sharedPreferences =
        remember { context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE) }

    firstName = sharedPreferences.getString("FIRST_NAME", "") ?: ""
    lastName = sharedPreferences.getString("LAST_NAME", "") ?: ""
    email = sharedPreferences.getString("EMAIL", "") ?: ""


    fun logoutHandler() {
        Toast.makeText(
            context,
            "Logout successful!",
            Toast.LENGTH_SHORT
        ).show()
        with(sharedPreferences.edit()) {
            clear()
            apply()
        }
        navController.navigate(Onboarding.route)
    }

    Column(modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp, vertical = 10.dp)) {
        Box(
            modifier = Modifier
                .fillMaxHeight(0.15f)
                .fillMaxWidth(),
        ) {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = "Little Lemon Logo",
                modifier = Modifier
                    .size(180.dp)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight(0.2f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.CenterStart,
            ) {
                Text(
                    text = "Personal information",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    fontFamily = KarlaFamily
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {

                Text(
                    text = "First name", fontSize = 14.sp,
                    fontFamily = KarlaFamily
                )
                OutlinedTextField(
                    value = firstName,
                    onValueChange = { firstName = it },
                    enabled = false,
                    placeholder = {
                        Text(firstName)
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Last name", fontSize = 14.sp,
                    fontFamily = KarlaFamily
                )
                OutlinedTextField(
                    value = lastName,
                    onValueChange = { lastName = it },
                    enabled = false,
                    placeholder = {
                        Text(lastName)
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Email", fontSize = 14.sp,
                    fontFamily = KarlaFamily
                )
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    enabled = false,
                    placeholder = {
                        Text(email)
                    },
                    modifier = Modifier.fillMaxWidth()
                )

            }
            Box(
                modifier = Modifier
                    .fillMaxHeight(0.2f)
                    .fillMaxWidth()
            ) {
                Button(
                    onClick = {
                        logoutHandler()
                    },
                    colors = ButtonColors(
                        containerColor = SecondaryColor,
                        contentColor = Color.Black,
                        disabledContainerColor = SecondaryColor,
                        disabledContentColor = Color.Black
                    ),
                    border = BorderStroke(width = 1.dp, color = Color.Black),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Logout", fontWeight = FontWeight.SemiBold, fontSize = 18.sp,
                        fontFamily = KarlaFamily
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    val navController = rememberNavController()
    ProfileScreen(navController)
}