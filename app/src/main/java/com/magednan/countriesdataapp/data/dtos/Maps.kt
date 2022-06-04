package com.magednan.countriesdataapp.data.dtos

import java.io.Serializable


data class Maps(
    val googleMaps: String,
    val openStreetMaps: String
): Serializable
