package com.example.decorhome

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.decorhome.DpHelper.Routers
import com.example.decorhome.DpHelper.TabbarItem
import com.example.decorhome.StackScreen.Detail
import com.example.decorhome.StackScreen.LoginScreen
import com.example.decorhome.StackScreen.Register
import com.example.decorhome.StackScreen.Wellcome
import com.example.decorhome.TabScreen.Favorite
import com.example.decorhome.TabScreen.Home
import com.example.decorhome.TabScreen.Notification
import com.example.decorhome.TabScreen.Profile
import com.example.decorhome.ui.theme.DecorHomeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Tabbar()
        }
    }
}


@Composable
fun App(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routers.Wellcome) {
        composable(Routers.Wellcome){
            Wellcome(navController)
        }
        composable(Routers.Login){
            LoginScreen(navController)
        }
        composable(Routers.Register){
            Register(navController)
        }
        composable(Routers.Tabbar){
            Tabbar()
        }


    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Tabbar() {
    val navController = rememberNavController()

    val homeTab = TabbarItem("home", R.drawable.homefocus, R.drawable.home)
    val favoriteTab = TabbarItem("favorite", R.drawable.favoritefocus, R.drawable.favorite)
    val notificationTab = TabbarItem("notification", R.drawable.notificefocus, R.drawable.notifi)
    val profileTab = TabbarItem("profile", R.drawable.profilefocus, R.drawable.profile)

    val tabBarItems = listOf(homeTab, favoriteTab, notificationTab, profileTab)
    Scaffold(
        bottomBar = { TabView(tabBarItems, navController) }
    ) {
        NavHost(navController = navController, startDestination = "home") {
            composable("home") { Home(navController) }
            composable("favorite") { Favorite() }
            composable("notification") { Notification() }
            composable("profile") { Profile() }
            composable("Detail/{_id}",
                arguments = listOf(navArgument("_id") {type = NavType.StringType})
            ) { backStackEntry ->
                Detail(_id = backStackEntry.arguments?.getString("_id"))
            }

        }
    }
}


@Composable
fun TabView(tabBarItems: List<TabbarItem>, navController: NavController) {
    var selectedTabIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
    NavigationBar {
        tabBarItems.forEachIndexed { index, tabBarItem ->
            NavigationBarItem(
                selected = selectedTabIndex == index,
                onClick = {
                    selectedTabIndex = index
                    navController.navigate(tabBarItem.title)
                },
                icon = {
                    TabBarIconView(
                        isSelected = selectedTabIndex == index,
                        selectedIcon = tabBarItem.selectedIcon,
                        unselectedIcon = tabBarItem.unselectedIcon,
                        title = tabBarItem.title,
                    )
                },
                label = { Text(tabBarItem.title) })
        }
    }
}

@Composable
fun TabBarIconView(
    isSelected: Boolean,
    selectedIcon: Int,
    unselectedIcon: Int,
    title: String,
) {
    Image(
        painter = painterResource(id = if (isSelected) selectedIcon else unselectedIcon),
        modifier = Modifier
            .width(24.dp)
            .height(24.dp),
        contentDescription = title
    )
}