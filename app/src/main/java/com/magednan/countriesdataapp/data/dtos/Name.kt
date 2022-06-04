package com.magednan.countriesdataapp.data.dtos

import java.io.Serializable

data class Name (
    val common: String?=null,
    val official: String?=null,
    val symbol:String?=null
): Serializable