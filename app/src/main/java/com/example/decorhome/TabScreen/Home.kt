package com.example.decorhome.TabScreen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.decorhome.R
import com.example.decorhome.Service.CategoryResponse
import com.example.decorhome.Service.ViewModelApp
import androidx.compose.foundation.lazy.items
import coil.compose.AsyncImage
import com.example.decorhome.Service.Category
import com.example.decorhome.Service.Product
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items


// Sample categories data




@Composable
fun Home(navController: NavController,viewModelApp: ViewModelApp = viewModel()) {
    val listcate by viewModelApp.listcate
    val product by viewModelApp.listproduct
    val type by remember  { mutableStateOf("") }

    LaunchedEffect(listcate) {
        viewModelApp.getcateViewModel()
        listcate?.let {
//            if (it.type.isNotEmpty()){
//                type = it.type[0]._id
//                viewModelApp.getcateViewModel(type)
//            }
        }
    }
    LaunchedEffect(product) {
        viewModelApp.getproductViewModel()
        product?.let {
//            if (it.type.isNotEmpty()){
//                type = it.type[0]._id
//                viewModelApp.getcateViewModel(type)
//            }
        }
    }

    Box(modifier = Modifier.padding(top = 40.dp, start = 20.dp, end = 20.dp)) {
        Column {
            // Header Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.sreach),
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier.size(22.dp)
                )
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "Make home",
                        color = Color(0xFF909090),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W400,
                    )
                    Text(
                        text = "BEAUTIFUL".uppercase(),
                        color = Color(0xFF242424),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W700,
                    )
                }
                Icon(
                    painter = painterResource(id = R.drawable.cart),
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier.size(22.dp)
                )
            }

            // Categories
            LazyRow(
                contentPadding = PaddingValues(vertical = 16.dp, horizontal = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(listcate?.type.orEmpty()) { item : Category ->
                    Card(
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .padding(4.dp)
                            .clickable {

                            }
                    ) {
                        Box(
                            modifier = Modifier
                                .padding(horizontal = 16.dp, vertical = 8.dp)
                                .height(40.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = item.name,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                }
            }
            // Product List (Placeholder)
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(bottom = 100.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(product?.product.orEmpty()) { item: Product ->
                    Card(
                        modifier = Modifier
                            .clickable {
                                navController.navigate("Detail/${item._id}")
                            }
                            .background(Color.White, shape = RoundedCornerShape(8.dp))
                    ) {
                        Column(
                            modifier = Modifier.padding(8.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            AsyncImage(
                                model = item.image,
                                contentDescription = "",
                                modifier = Modifier
                                    .size(150.dp)
                                    .background(Color.White, shape = RoundedCornerShape(8.dp))
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = item.name,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W400
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "$ ${item.price}",
                                color = Color.Black,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W700
                            )
                        }
                    }
                }
            }
        }
    }
}
