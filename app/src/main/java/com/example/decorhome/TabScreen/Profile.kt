package com.example.decorhome.TabScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.decorhome.R

@Composable
fun Profile(){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row (

            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 25.dp),
            Arrangement.SpaceBetween

        ){
            Image(
                painter = painterResource(id = R.drawable.sreach), // Thay thế icon_placeholder bằng ID của icon
                contentDescription = "Logo",
                modifier = Modifier.size(20.dp)
            )
            Text(text = "Profile",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,

            )
            Image(
                painter = painterResource(id = R.drawable.out), // Thay thế icon_placeholder bằng ID của icon
                contentDescription = "Logo",
                modifier = Modifier.size(20.dp)
            )
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 18.dp),
            
        ){
            Image(
                painter = painterResource(id = R.drawable.avatar), contentDescription = "",
                modifier = Modifier
                    .size(75.dp)
                    .clip(RoundedCornerShape(35.dp)),
                )
            Column (
                modifier = Modifier
                    .padding(start = 16.dp),
            ){
                Text(text = "Soda",
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp)
                Text(text = "soda@gmail.com",
                    color = Color.Gray,
                    modifier = Modifier.padding(top = 10.dp)
                )
            }
        }
        Column (
            modifier = Modifier.padding(top = 20.dp),

        ){
            Row (

                modifier = Modifier
                    .shadow(
                        elevation = 8.dp, // Độ cao của đổ bóng
                    )
                    .background(Color.White) // Đặt nền để bóng hiển thị rõ
                    .padding(top = 15.dp) // Khoảng cách bên trong
                    .fillMaxWidth(), // Chiều rộng full
                Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,


            ){
                Column {
                    Text(text = "My order",
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp)
                    Text(text = "Already have 10 orders",
                        color = Color.Gray,
                        modifier = Modifier.padding(top = 10.dp)
                    )
                }
                Image(painter = painterResource(id = R.drawable.right), contentDescription = "")
            }
        }

    }
}