package com.magednan.countriesdataapp.presention.localListing

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.magednan.countriesdataapp.data.dtos.CountryInfoResponseItem


/*
* single item for All Countries Rv
* */
@Composable
fun LocalDbListingRvItem(
    item: CountryInfoResponseItem, modifier: Modifier,
    viewModel: LocalDbListingViewModel = hiltViewModel()
) {
    Column() {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier

        ) {
            Image(
                painter = rememberImagePainter(data = item.flags?.png,
                    builder = {
                        crossfade(true)
                        transformations(CircleCropTransformation())
                    }),
                contentDescription = "Flag Poster",
                alignment = Alignment.CenterStart,
                modifier = Modifier
                    .size(150.dp)
                    .padding(10.dp)
            )

            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = item.name?.official.toString(),
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Clip,
                    maxLines = 1,
                    modifier = Modifier.padding(5.dp)
                )
                Text(
                    text = "Capital:${item.capital}",
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    modifier = Modifier.padding(5.dp)
                )
                Text(
                    text = "Area:${item.area.toString()}",
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    modifier = Modifier.padding(5.dp)
                )
                Text(
                    text = "Is Independent:${item.independent.toString()}",
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    modifier = Modifier.padding(5.dp)
                )
                Text(
                    text = "Population:${item.population}",
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    modifier = Modifier.padding(5.dp)
                )
            }

        }

        Button(onClick = {
            viewModel.deleteItem(item)
        },Modifier.fillMaxWidth()) {
            Text(text = "Remove Item")
        }
    }

    Divider(thickness = 9.dp)
}