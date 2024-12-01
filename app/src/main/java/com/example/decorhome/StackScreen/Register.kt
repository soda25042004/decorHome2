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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.decorhome.R
import com.example.decorhome.Service.RegisterRequest
import com.example.decorhome.Service.ViewModelApp


@Composable
fun Register(navController: NavController, viewModelApp: ViewModelApp = viewModel()) {

    val context = LocalContext.current
    val register by viewModelApp.register

    var name by remember { mutableStateOf("soda") }
    var email by remember { mutableStateOf("12345678") }
    var password by remember { mutableStateOf("1") }
    var confirmPassword by remember { mutableStateOf("1") }
    var errorMessage by remember { mutableStateOf("") }

    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }



    fun dangky() {
        val request = RegisterRequest(name, email, password)
        viewModelApp.registerViewModel(request)
    }

    LaunchedEffect(key1 = register) {
        if (register != null) {
            if (register?.status == true) {
                if (password == confirmPassword) {
                    navController.popBackStack()
                } else {
                    errorMessage = "Mật khẩu không khớp!"
                }
            }
            Toast.makeText(context, register?.message, Toast.LENGTH_SHORT).show()
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
            value = name,
            onValueChange = {name = it},
            label = { Text(text = "Name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        )
        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            label = { Text(text = "Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        )

        // Trường nhập mật khẩu
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.visiblepass),
                    contentDescription = null
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        )

        // Trường nhập lại mật khẩu
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text(text = "Confirm Password") },
            visualTransformation = if (confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.visiblepass),
                    contentDescription = null
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Hiển thị thông báo lỗi nếu có
        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = Color.Red,
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.height(16.dp))



        // Nút Sign in
        Button(
            onClick = {
                dangky()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(horizontal = 8.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "Sign UP",
                color = Color.White,
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Sign Up Text
        Text(
            text = "SIGN IN",
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}