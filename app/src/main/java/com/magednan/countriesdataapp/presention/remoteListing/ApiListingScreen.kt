package com.magednan.countriesdataapp.presention.remoteListing

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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.magednan.countriesdataapp.utils.Constant.COUNTRY_Info_Destination
import com.ramcosta.composedestinations.annotation.Destination


/*
* the home screen of the app
*/
@Composable
fun ApiListingScreen(
navController: NavController,
viewModel: ApiListingViewModel = hiltViewModel()
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(1f)
            .padding(10.dp)
    ) {
        viewModel.state.data?.size?.let {
            items(it) { index ->
                val item = viewModel.state.data?.get(index)
                if (item != null) {
                    ApiListingRvItem(item = item,
                        modifier = Modifier
                           .clickable {
                                navController.navigate(
                                    COUNTRY_Info_Destination +item.name?.common                               )
                            }
                            .fillMaxWidth()
                            .background(Color.LightGray, shape = RoundedCornerShape(15.dp)),
                    )
                }
            }
        }
    }

}