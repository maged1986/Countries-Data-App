package com.magednan.countriesdataapp.presention.localListing

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.magednan.countriesdataapp.presention.NavDestination
import com.magednan.countriesdataapp.utils.Constant
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@Composable
fun LocalDbListingScreen(
navController: NavController    ,
    viewModel: LocalDbListingViewModel = hiltViewModel()
) {
    val localContext = LocalContext.current
    LazyColumn(modifier = Modifier.fillMaxSize().padding(10.dp)) {

        viewModel.state.data?.size?.let {size->
            Toast.makeText(localContext!!,size?.toString(), Toast.LENGTH_LONG).show()
            items(size){i->
                val item= viewModel.state.data?.get(i)
                if (item != null) {
                    LocalDbListingRvItem(
                        item = item,
                        modifier = Modifier
                            .clickable{ navController.navigate(Constant.COUNTRY_Info_Destination +item.name?.common) }
                            .fillMaxWidth()
                            .background(Color.LightGray, shape = RoundedCornerShape(15.dp)),
                    )
                }
            }
        }
    }
}