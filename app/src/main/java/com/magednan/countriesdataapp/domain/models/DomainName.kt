package com.magednan.countriesdataapp.domain.models

import java.io.Serializable


data class DomainName(
    val common: String?=null,
    val official: String?=null,
    val symbol:String?=null
): Serializable
