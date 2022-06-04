package com.magednan.countriesdataapp.presention.remoteListing

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.magednan.countriesdataapp.data.dtos.CountryInfoResponseItem
import com.ramcosta.composedestinations.navigation.DestinationsNavigator


/*
* single item for All Countries Rv
* */
@Composable
fun ApiListingRvItem(item: CountryInfoResponseItem, modifier: Modifier,
){
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier =modifier

    ) {
        Image(painter = rememberImagePainter(data = item.flags?.png,
            builder = {
                crossfade(true)
                transformations(CircleCropTransformation())
            }),
            contentDescription = "Flag Poster",
            alignment = Alignment.CenterStart,
            modifier = Modifier.size(150.dp).padding(10.dp)
        )

        Column(verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start) {
            Text(text = item.name?.official.toString(),fontWeight = FontWeight.Bold, overflow = TextOverflow.Clip, maxLines = 1, modifier = Modifier.padding(5.dp))
            Text(text = "Capital:${item.capital}", fontWeight = FontWeight.Bold, overflow = TextOverflow.Ellipsis, maxLines = 1, modifier = Modifier.padding(5.dp))
            Text(text = "Area:${item.area.toString()}", fontWeight = FontWeight.Bold, overflow = TextOverflow.Ellipsis, maxLines = 1, modifier = Modifier.padding(5.dp))
            Text(text = "Is Independent:${item.independent.toString()}", fontWeight = FontWeight.Bold, overflow = TextOverflow.Ellipsis, maxLines = 1, modifier = Modifier.padding(5.dp))
            Text(text = "Population:${item.population}", fontWeight = FontWeight.Bold, overflow = TextOverflow.Ellipsis, maxLines = 1, modifier = Modifier.padding(5.dp))
        }
    }
    Divider(thickness = 9.dp)
}