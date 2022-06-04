package com.magednan.countriesdataapp.presention.countrydetails

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.magednan.countriesdataapp.data.dtos.CountryInfoResponseItem
import com.magednan.countriesdataapp.presention.NavDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


@Composable
//@Destination
fun CountryInfoScreen(
 //   item: CountryInfoResponseItem,
    viewModel: CountryInfoViewModel = hiltViewModel(),
    navController: NavController
){
    val item = viewModel.state
    val localContext = LocalContext.current

    if (item.item != null) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = item.item?.name?.official.toString(),
                    fontWeight = FontWeight.ExtraBold,
                    overflow = TextOverflow.Clip,
                    maxLines = 1,
                    modifier = Modifier.padding(5.dp)
                )
                Image(
                    painter = rememberImagePainter(data = item.item?.flags?.png),
                    contentDescription = "",
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .clip(shape = RoundedCornerShape(5.dp))
                )

                Text(
                    text = "Capital:${item.item?.capital}",
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    modifier = Modifier.padding(5.dp)
                )
                Text(
                    text = "Area:${item.item?.area.toString()}",
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    modifier = Modifier.padding(5.dp)
                )
                Text(
                    text = "Is Independent:${item.item?.independent.toString()}",
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    modifier = Modifier.padding(5.dp)
                )
                Text(
                    text = "Population:${item.item?.population}",
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    modifier = Modifier.padding(5.dp)
                )
                Text(
                    text = "Maps",
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    modifier = Modifier.padding(5.dp)
                )
            }

            IconButton(onClick = { item.item?.let { viewModel.saveCountry(it)
                Toast.makeText(localContext!!,"Country data Saved to favorite", Toast.LENGTH_LONG).show()}}, modifier = Modifier.clip(shape = RoundedCornerShape(10.dp)).align(
                Alignment.CenterStart).background(
                Color.Magenta)) {
                Icon(Icons.Outlined.Favorite, contentDescription = "")
            }

        }
    }
}
