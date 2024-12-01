package com.example.decorhome.StackScreen

import android.widget.Toast
import androidx.compose.foundation.Image
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
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.decorhome.R
import com.example.decorhome.Service.LoginRequest
import com.example.decorhome.Service.ViewModelApp

@Composable
fun LoginScreen(navController: NavController, viewModelApp: ViewModelApp = viewModel()) {
    val context = LocalContext.current
    val login by viewModelApp.login
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    fun dangnhap(){
        val request = LoginRequest(email, password)
        viewModelApp.loginViewModel(request)
    }
    LaunchedEffect(key1 = login) {
        if (login != null){
            if (login?.status == true){
                navController.navigate("Tabbar")
            }
            Toast.makeText(context, login?.message, Toast.LENGTH_SHORT).show()
        }

    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            Arrangement.SpaceAround

        ) {
            Image(
                painter = painterResource(id = R.drawable.line), // Thay thế icon_placeholder bằng ID của icon
                contentDescription = "Logo",
                modifier = Modifier.size(100.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.icon1), // Thay thế icon_placeholder bằng ID của icon
                contentDescription = "Logo",
                modifier = Modifier.size(80.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.line), // Thay thế icon_placeholder bằng ID của icon
                contentDescription = "Logo",
                modifier = Modifier.size(100.dp)
            )
        }
        // Icon


        Spacer(modifier = Modifier.height(16.dp))

        // "Hello !" Text
        Text(
            text = "Hello !",
            fontSize = 32.sp,
            fontWeight = FontWeight.Light,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(20.dp))

        // "WELCOME BACK" Text
        Text(
            text = "WELCOME BACK",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(52.dp))

        // Email Field
        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            label = { Text(text = "Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Password Field
        var passwordVisible by remember { mutableStateOf(false) }
        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            label = { Text(text = "Password") },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.visiblepass), // Thay thế ic_visibility bằng ID của icon hiển thị
                    contentDescription = null
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Forgot Password
        Text(
            text = "Forgot Password",
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(54.dp))



        // Log in Button
        Button(
            onClick = { dangnhap() },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(horizontal = 8.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "Log in",
                color = Color.White,
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(onClick = {
            navController.navigate("Register")
        }) {
            Text(
                text = "SIGN UP",
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

    }
}