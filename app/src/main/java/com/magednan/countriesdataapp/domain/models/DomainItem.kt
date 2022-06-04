package com.magednan.countriesdataapp.domain.models

import java.io.Serializable


data class DomainItem(
    val area: Double? = null,
    val borders: List<String>? = null,
    val capital: List<String>? = null,
    val continents: List<String>? = null,
    val fifa: String? = null,
    val flag: String = "",
    val flags: DomainFlags? = null,
    val independent: Boolean? = null,
    val landlocked: Boolean? = null,
    val latlng: List<Double>? = null,
    val maps: DomainMaps? = null,
    val name: DomainName? = null,
    val population: Int? = null,
    val region: String? = null,
    val startOfWeek: String? = null,
    val status: String? = null,
    val subregion: String? = null,
    val timezones: List<String>? = null,
    val tld: List<String>? = null,
    val unMember: Boolean? = null
) : Serializable
