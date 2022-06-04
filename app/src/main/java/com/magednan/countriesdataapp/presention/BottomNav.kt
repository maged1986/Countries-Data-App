package com.magednan.countriesdataapp.presention

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun BottomNav(navController: NavHostController) {
    var state = remember {
        mutableStateOf("Home")
    }

    BottomNavigation(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        BottomNavigationItem(selected = (state.value == "Home"),
            onClick = {
                state.value = "Home"
                navController.navigate(NavDestination.ApiListingScreen.route)
            }, label = { Text(text = "Home") },
            icon = ({
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = ""
                )
            })
        )
        BottomNavigationItem(selected = (state.value == "Favorite"),
            onClick = {
                state.value = "Favorite"

                navController.navigate(NavDestination.LocalDbListingScreen.route)
            }, label = { Text(text = "Favorite") },
            icon = ({
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = ""
                )
            })
        )
    }

}