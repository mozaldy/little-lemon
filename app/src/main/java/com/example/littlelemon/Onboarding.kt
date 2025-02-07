package com.example.littlelemon

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.littlelemon.ui.theme.PrimaryColor
import com.example.littlelemon.ui.theme.SecondaryColor

@Composable
fun Onboarding() {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxHeight(0.15f)
                .fillMaxWidth(),
            contentAlignment = Alignment.TopCenter,
        ) {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = "Little Lemon Logo",
                modifier = Modifier
                    .fillMaxSize(0.7f)
                    .padding(top = 40.dp)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxHeight(0.15f)
                .fillMaxWidth()
                .background(color = PrimaryColor), contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Let's get to know you",
                fontSize = 26.sp,
                color = Color.White,
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
                    fontSize = 18.sp
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {

                Text(
                    text = "First name", fontSize = 14.sp
                )
                OutlinedTextField(value = firstName, onValueChange = { firstName = it }, label = {
                    Text(
                        text = "First name", fontSize = 14.sp
                    )
                }, modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Last name", fontSize = 14.sp
                )
                OutlinedTextField(value = lastName, onValueChange = { lastName = it }, label = {
                    Text(
                        text = "Last name", fontSize = 14.sp
                    )
                }, modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Email", fontSize = 14.sp
                )
                OutlinedTextField(value = email, onValueChange = { email = it }, label = {
                    Text(
                        text = "Email", fontSize = 14.sp
                    )
                }, modifier = Modifier.fillMaxWidth())

            }
            Box(
                modifier = Modifier
                    .fillMaxHeight(0.2f)
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
            ) {
                Button(
                    onClick = {},
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
                        text = "Register", fontWeight = FontWeight.SemiBold, fontSize = 18.sp
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingPreview() {
    Onboarding()
}
