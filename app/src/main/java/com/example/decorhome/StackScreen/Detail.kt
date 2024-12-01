package com.example.decorhome.StackScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.decorhome.Service.ViewModelApp

@Composable
fun Detail(
    _id: String?,
    viewModelApp: ViewModelApp = viewModel()
) {
    val detailProduct by viewModelApp.detailproduct

    // Gọi API khi màn hình mở
    LaunchedEffect(_id) {
        _id?.let { viewModelApp.getproductById(it) }
    }

    // Hiển thị sản phẩm
    Column(modifier = Modifier.padding(16.dp)) {
        detailProduct?.let { response ->
            response.product?.let { product ->
                AsyncImage(
                    model = product.image,
                    contentDescription = null,
                    modifier = Modifier
                        .size(150.dp)
                        .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
                )
                Text(
                    text = product.name,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Text(
                    text = "Price: $${product.price}",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(top = 4.dp)
                )
                Text(
                    text = "Origin: ${product.origin}",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(top = 4.dp)
                )
                Text(
                    text = "Description: ${product.size}",
                    fontSize = 14.sp,
                    modifier = Modifier.padding(top = 4.dp)
                )
            } ?: run {
                Text(text = "Loading...", fontSize = 16.sp)
            }
        }
    }
}
