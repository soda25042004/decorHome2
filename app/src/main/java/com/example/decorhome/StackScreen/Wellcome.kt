package com.example.decorhome.StackScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.decorhome.R
import com.example.decorhome.ui.theme.Backgound
import com.example.decorhome.ui.theme.Button242424

@Composable
fun Wellcome(navController: NavController   ){
    Column {
        Box(

            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.background),
                contentDescription = "backGround",
                modifier = Modifier.fillMaxSize()
            )
            Column(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text(
                    text = "MAKE YOUR",
                    fontSize = 24.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray,
                    modifier = Modifier.padding(bottom = 15.dp, start = 25.dp)
                )
                Text(
                    text = "HOME BEAUTIFUL",
                    fontSize = 35.sp,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 25.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "The best simple place where you\n" +
                            "discover most wonderful furnitures\n" +
                            "and make your home beautiful",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.Gray,
                    lineHeight = 24.sp,
                    modifier = Modifier.padding(top = 20.dp, bottom = 55.dp, start = 50.dp),
                )

                Spacer(modifier = Modifier.height(32.dp))

                // Get Started Button
                Button(
                    onClick = { navController.navigate("Login")},
                    shape = RoundedCornerShape(8.dp),
                    colors =  ButtonDefaults.outlinedButtonColors(Backgound),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(horizontal = 32.dp)
                        .width(159.dp)
                        .height(54.dp)


                ) {
                    Text(
                        text = "Get Started",
                        color = Color.White,
                        fontSize = 16.sp
                    )
                }

            }
        }
    }
}