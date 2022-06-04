package com.magednan.countriesdataapp.domain.models

import java.io.Serializable


data class DomainMaps(
    val googleMaps: String,
    val openStreetMaps: String
): Serializable
