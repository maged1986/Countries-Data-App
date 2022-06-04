package com.magednan.countriesdataapp.data.dtos

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "items")
data class CountryInfoResponseItem(
    val id:Int?=null,
    val area: Double? = null,
    val borders: List<String>? = null,
    val capital: List<String>? = null,
    val continents: List<String>? = null,
    val fifa: String? = null,
    @PrimaryKey
    val flag: String = "",
    val flags: Flags? = null,
    val independent: Boolean? = null,
    val landlocked: Boolean? = null,
    val latlng: List<Double>? = null,
    val maps: Maps? = null,
    val name: Name? = null,
    val population: Int? = null,
    val region: String? = null,
    val startOfWeek: String? = null,
    val status: String? = null,
    val subregion: String? = null,
    val timezones: List<String>? = null,
    val tld: List<String>? = null,
    val unMember: Boolean? = null
) : Serializable
