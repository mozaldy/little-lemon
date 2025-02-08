package com.example.littlelemon

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import com.example.littlelemon.ui.theme.LittleLemonColor

@Composable
fun OnboardingScreen(navController: NavHostController) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    val context = LocalContext.current
    val sharedPreferences = remember { context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE) }


    fun registrationHandler(){
        if (firstName.isBlank() || lastName.isBlank() || email.isBlank()) {
            Toast.makeText(
                context,
                "Registration unsuccessful. Please enter all data.",
                Toast.LENGTH_SHORT
            ).show()
        }
        else {
            Toast.makeText(
                context,
                "Registration successful!",
                Toast.LENGTH_SHORT
            ).show()

            with(sharedPreferences.edit()){
                putString("FIRST_NAME", firstName)
                putString("LAST_NAME", lastName)
                putString("EMAIL", email)
                putBoolean("IS_LOGGED_IN", true)
                apply()
            }
            navController.navigate(Home.route)
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = "Little Lemon Logo",
                modifier = Modifier
                    .size(180.dp)
                    .align(Alignment.Center)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxHeight(0.15f)
                .fillMaxWidth()
                .background(color = LittleLemonColor.green), contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Let's get to know you",
                fontSize = 26.sp,
                color = Color.White,
                fontFamily = KarlaFamily
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight(0.2f)
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
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
                    .padding(horizontal = 20.dp)
            ) {

                Text(
                    text = "First name", fontSize = 14.sp,
                    fontFamily = KarlaFamily
                )
                OutlinedTextField(value = firstName, onValueChange = { firstName = it }, placeholder = {Text("Tilly")}, modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Last name", fontSize = 14.sp,
                    fontFamily = KarlaFamily
                )
                OutlinedTextField(value = lastName, onValueChange = { lastName = it }, placeholder = {Text("Jane")}, modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Email", fontSize = 14.sp,
                    fontFamily = KarlaFamily
                )
                OutlinedTextField(value = email, onValueChange = { email = it }, placeholder = {Text("tilly@site.com")}, modifier = Modifier.fillMaxWidth())

            }
            Box(
                modifier = Modifier
                    .fillMaxHeight(0.2f)
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
            ) {
                Button(
                    onClick = {
                        registrationHandler()
                    },
                    colors = ButtonColors(
                        containerColor = LittleLemonColor.yellow,
                        contentColor = Color.Black,
                        disabledContainerColor = LittleLemonColor.yellow,
                        disabledContentColor = Color.Black
                    ),
                    border = BorderStroke(width = 1.dp, color = Color.Black),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Register", fontWeight = FontWeight.SemiBold, fontSize = 18.sp,
                        fontFamily = KarlaFamily
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingScreenPreview(){
    val navController = rememberNavController()
    OnboardingScreen(navController)
}